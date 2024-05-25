package com.example.AntonioDemo.ws;

import com.example.AntonioDemo.dto.AccountsDTO;
import com.example.AntonioDemo.models.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/accounts")
public class AccountsWS {

    @Autowired
    private AccountsDTO accountsDTO;

    @PostMapping()
    public ResponseEntity post(@RequestBody Account account){

        String res = accountsDTO.createAccount(account);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable String id){
        String res = accountsDTO.getAccount(Integer.valueOf(id));
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @GetMapping()
    public ResponseEntity get(){
        String res = accountsDTO.getAccounts();
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @PutMapping()
    public ResponseEntity put(@RequestBody Account account){
        String res = accountsDTO.updateAccount(account);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity patch(@RequestBody Account account){
        String res = accountsDTO.updateAccount(account);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        accountsDTO.deleteAccount(Integer.valueOf(id));
        return new ResponseEntity<>("Account deleted successfully", HttpStatus.ACCEPTED);
    }
}
