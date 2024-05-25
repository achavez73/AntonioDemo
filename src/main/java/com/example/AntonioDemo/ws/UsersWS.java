package com.example.AntonioDemo.ws;

import com.example.AntonioDemo.dto.UsersDTO;
import com.example.AntonioDemo.models.Account;
import com.example.AntonioDemo.models.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UsersWS {

    @Autowired
    private UsersDTO usersDTO;

    @PostMapping()
    public ResponseEntity post(@RequestBody User user){
        String res = usersDTO.createUser(user);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable String id){
        String res = usersDTO.getUser(Integer.valueOf(id));
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @GetMapping()
    public ResponseEntity get(){
        String res = usersDTO.getUsers();
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @PutMapping()
    public ResponseEntity put(@RequestBody User user){
        String res = usersDTO.updateUser(user);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity patch(@RequestBody User user){
        String res = usersDTO.updateUser(user);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        usersDTO.deleteUser(Integer.valueOf(id));
        return new ResponseEntity<>("User deleted succesfully", HttpStatus.ACCEPTED);
    }
    @PostMapping("/{id}/accounts")
    public ResponseEntity addAccountUser(@PathVariable String id, @RequestBody Account account){
        String res = usersDTO.addAccount(Integer.valueOf(id),account);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/accounts/{accountId}")
    public ResponseEntity deleteUserAccount(@PathVariable String id, @PathVariable String accountId){
        usersDTO.deleteAccount(Integer.valueOf(id),Integer.valueOf(accountId));
        return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}/accounts/{accountId}")
    public ResponseEntity getAccount(@PathVariable String id,@PathVariable String accountId){
        String res = usersDTO.getUserAccount(Integer.valueOf(id),Integer.valueOf(accountId));
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}/accounts")
    public ResponseEntity getAccounts(@PathVariable String id){
        String res = usersDTO.getUserAccounts(Integer.valueOf(id));
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }
}
