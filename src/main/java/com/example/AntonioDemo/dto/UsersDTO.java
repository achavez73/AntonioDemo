package com.example.AntonioDemo.dto;

import com.example.AntonioDemo.models.Account;
import com.example.AntonioDemo.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersDTO {

    public String createUser(User user);
    public String getUser(int userId);
    public String updateUser(User user);
    public void deleteUser(int userId);
    public String getUsers();
    public String addAccount(int id, Account account);
    public void deleteAccount(int id, int accountId);
    public String getUserAccount(int id, int accounId);
    public String getUserAccounts(int id);
}
