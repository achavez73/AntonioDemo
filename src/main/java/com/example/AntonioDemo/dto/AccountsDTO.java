package com.example.AntonioDemo.dto;

import com.example.AntonioDemo.models.Account;
import com.example.AntonioDemo.models.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountsDTO {

    public String createAccount(Account account);
    public String getAccount(int accountId);
    public String updateAccount(Account account);
    public void deleteAccount(int accountId);
    public String getAccounts();

}
