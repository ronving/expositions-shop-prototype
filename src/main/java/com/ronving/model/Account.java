package com.ronving.model;

import com.ronving.model.roles.ROLE;

public class Account {
    private int id;
    private String login;
    private String password;
    private int balance;
    private ROLE role;

    public Account() {
        role = ROLE.UNKNOWN;
    }

    public Account(int id, String login, String password, int balance, ROLE role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.role = role;
    }

    //account without balance
    public Account(int id, String login, String password, ROLE role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole() {
        this.role = ROLE.USER;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
