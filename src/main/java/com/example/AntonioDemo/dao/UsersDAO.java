package com.example.AntonioDemo.dao;

import com.example.AntonioDemo.models.Account;
import com.example.AntonioDemo.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersDAO {

    public User createUser(User user);
    public User getUser(int userId);
    public User updateUser(User user);
    public void deleteUser(int userId);
    public List<User> getUsers();
    public List<Account> getUserAccounts(int userId);
}
