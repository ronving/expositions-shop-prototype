package com.ronving.dao.interfaces;

import com.ronving.model.ROLE;
import com.ronving.model.User;

public interface UserDAO {
    User getUserById(final int id);
    User getUserByLoginPassword(final String login, final String password);
    ROLE getRoleByLoginPassword(final String login, final String password);
    boolean userIsExist(final String login, final String password);
    boolean addNewUser(final User user);
}
