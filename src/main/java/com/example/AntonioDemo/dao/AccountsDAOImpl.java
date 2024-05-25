package com.example.AntonioDemo.dao;

import com.example.AntonioDemo.models.Account;
import com.example.AntonioDemo.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AccountsDAOImpl implements AccountsDAO{


    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoUser");

    @Override
    public Account createAccount(Account account) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class,account.getUser().getUserId());
        account.setUser(user);
        em.persist(account);
        em.getTransaction().commit();
        em.close();

        return account;
    }

    public List<Account> getAccounts(){
        List<Account> res;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        res = em.createQuery("from Account ",Account.class).getResultList();
        em.close();
        return res;

    }

    @Override
    public Account getAccount(int accountId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Account account = em.find(Account.class, accountId);
        em.close();
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Account res = em.merge(account);
        em.getTransaction().commit();
        em.close();
        return res;
    }

    @Override
    public void deleteAccount(int accountId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Account account = em.find(Account.class,accountId);
        em.remove(account);
        em.getTransaction().commit();
        em.close();

    }
}
