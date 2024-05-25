package com.example.AntonioDemo.dto;

import com.example.AntonioDemo.dao.AccountsDAO;
import com.example.AntonioDemo.dao.UsersDAO;
import com.example.AntonioDemo.models.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.example.AntonioDemo.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsersDTOImpl implements UsersDTO {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private AccountsDAO accountsDAO;

    public String createUser(User user) {
        String res = "";
        try{
            ObjectMapper om = new ObjectMapper();
            res = om.writeValueAsString(usersDAO.createUser(user));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return res;
    };


    public String getUser(int userId){

        String res="";
        try{
            ObjectMapper om = new ObjectMapper();
            res = om.writeValueAsString(usersDAO.getUser(userId));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return res;
    };
    public String updateUser(User user){

        String res = "";
        try{
            ObjectMapper om = new ObjectMapper();
            res = om.writeValueAsString(usersDAO.updateUser(user));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return res;
    };
    public void deleteUser(int userId){
        usersDAO.deleteUser(userId);
    };

    public String getUsers(){

        String res = "";
        try{
            ObjectMapper om = new ObjectMapper();
            res = om.writeValueAsString(usersDAO.getUsers());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public String addAccount(int id, Account account) {

        User user = new User(id);
        account.setUser(user);
        String res = "";
        try{
            ObjectMapper om = new ObjectMapper();
            res = om.writeValueAsString(accountsDAO.createAccount(account));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public void deleteAccount(int id, int accountId) {
        accountsDAO.deleteAccount(accountId);
    }

    @Override
    public String getUserAccount(int id, int accountId) {
        String res = "";
        try{
            ObjectMapper om = new ObjectMapper();
            res = om.writeValueAsString(accountsDAO.getAccount(accountId));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public String getUserAccounts(int id) {
        String res = "";
        try{
            ObjectMapper om = new ObjectMapper();
            res = om.writeValueAsString(usersDAO.getUserAccounts(id));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return res;
    }


}
