package com.example.AntonioDemo.dao;

import com.example.AntonioDemo.models.Account;
import com.example.AntonioDemo.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsDAO {

    public Account createAccount(Account account);
    public Account getAccount(int accountId);
    public Account updateAccount(Account account);
    public void deleteAccount(int accountId);
    public List<Account> getAccounts();

}
