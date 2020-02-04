package com.ronving.model;

import com.ronving.model.roles.ROLE;

public class Account {
    private int id;
    private String login;
    private String password;
    private int balance;
    private ROLE role;

    /**
     * default Account constructor.
     */
    public Account() {
        role = ROLE.UNKNOWN;
    }

    /**
     * Account constructor for all but without id.
     */
    public Account(int id, String login, String password, int balance, ROLE role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.role = role;
    }

    /**
     * Getter for Account id
     *
     * @return id primary identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for Account id
     *
     * @param id primary identifier
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for Account login
     *
     * @return Account holder`s login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter for Account login
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Getter for Account password
     *
     * @return Account holder`s password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for Account password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for Account role
     *
     * @return Account role
     */
    public ROLE getRole() {
        return role;
    }

    /**
     * Setter for Account role
     *
     * default value USER
     */
    public void setRole() {
        this.role = ROLE.USER;
    }

    /**
     * Getter for Account balance
     *
     * @return Account holder`s balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Setter for Account balance
     *
     * @param balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

}
