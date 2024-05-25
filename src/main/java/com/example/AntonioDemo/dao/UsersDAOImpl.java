package com.example.AntonioDemo.dao;

import com.example.AntonioDemo.models.Account;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import com.example.AntonioDemo.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsersDAOImpl implements UsersDAO{


    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoUser");

    @Override
    public User createUser(User user) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();

        return user;
    }

    public List<User> getUsers(){
        List<User> res;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        res = em.createQuery("from User",User.class).getResultList();
        em.close();
        return res;

    }

    @Override
    public List<Account> getUserAccounts(int userId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, userId);
        em.close();
        return user.getAccountsList();
    }

    @Override
    public User getUser(int userId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, userId);
        em.close();
        return user;
    }

    @Override
    public User updateUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User res = em.merge(user);
        em.getTransaction().commit();
        em.close();
        return res;
    }

    @Override
    public void deleteUser(int userId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class,userId);
        em.remove(user);
        em.getTransaction().commit();
        em.close();

    }


}
