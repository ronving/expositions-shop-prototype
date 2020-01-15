package com.ronving.dao;

import com.ronving.model.roles.ROLE;
import com.ronving.model.Account;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final List<Account> store = new ArrayList<>();

    public Account getUserById(int id) {

        Account result = new Account();
        result.setId(-1);

        for (Account user : store) {
            if (user.getId() == id) {
                result = user;
            }
        }

        return result;
    }

    public Account getUserByLoginPassword(final String login, final String password) {

        Account result = new Account();
        result.setId(-1);

        for (Account user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user;
            }
        }

        return result;
    }

    public boolean addNewUser(final Account user) {

        for (Account u : store) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }

        return store.add(user);
    }

    public ROLE getRoleByLoginPassword(final String login, final String password) {
        ROLE result = ROLE.UNKNOWN;

        for (Account user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user.getRole();
            }
        }

        return result;
    }

    public boolean userIsExist(final String login, final String password) {

        boolean result = false;

        for (Account user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }

        return result;
    }
}
