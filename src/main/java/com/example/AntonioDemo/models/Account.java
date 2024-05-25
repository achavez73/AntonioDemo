package com.example.AntonioDemo.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.proxy.Mixin;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private int accountId;
    @Column(name = "ACCOUNT_NAME")
    private String accountName;
    @Column(name = "ACCOUNT_CURRENCY")
    private String accountCurrency;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    public Account() {

    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountCurrency='" + accountCurrency + '\'' +
                ", user=" + user.getUserId() +
                '}';
    }
}
