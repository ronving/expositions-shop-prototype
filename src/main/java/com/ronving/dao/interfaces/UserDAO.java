package com.ronving.dao.interfaces;

import com.ronving.model.roles.ROLE;
import com.ronving.model.Account;

public interface UserDAO {
    Account getUserById(final int id);
    Account getUserByLoginPassword(String login, String password);
    ROLE getRoleByLogin(String login, String password);
    boolean userIsExist(String login, String password);
    boolean addNewUser(Account account);
}
