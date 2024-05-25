package com.example.AntonioDemo.dto;

import com.example.AntonioDemo.dao.AccountsDAO;
import com.example.AntonioDemo.dao.UsersDAO;
import com.example.AntonioDemo.models.Account;
import com.example.AntonioDemo.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountsDTOImpl implements AccountsDTO {

    @Autowired
    private AccountsDAO accountsDAO;

    public String createAccount(Account account){
        String res = "";
        try{
            ObjectMapper om = new ObjectMapper();
            res = om.writeValueAsString(accountsDAO.createAccount(account));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return res;
    };
    public String getAccount(int accountId){

        String res="";
        try{
            ObjectMapper om = new ObjectMapper();
            res = om.writeValueAsString(accountsDAO.getAccount(accountId));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return res;
    };
    public String updateAccount(Account account){
        String res = "";
        try{
            ObjectMapper om = new ObjectMapper();
            res = om.writeValueAsString(accountsDAO.updateAccount(account));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return res;
    };
    public void deleteAccount(int accountId){
        accountsDAO.deleteAccount(accountId);
    };

    public String getAccounts(){

        String res = "";
        try{
            ObjectMapper om = new ObjectMapper();
            res = om.writeValueAsString(accountsDAO.getAccounts());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return res;
    }


}
