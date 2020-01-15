package com.ronving.dao.interfaces;

import com.ronving.model.roles.ROLE;
import com.ronving.model.Account;

public interface UserDAO {
    Account getUserById(final int id);
    Account getUserByLoginPassword(final String login, final String password);
    ROLE getRoleByLoginPassword(final String login, final String password);
    boolean userIsExist(final String login, final String password);
    boolean addNewUser(final Account user);
}
