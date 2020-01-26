package com.ronving.dao.interfaces;

import com.ronving.model.roles.ROLE;
import com.ronving.model.Account;

public interface AccountDAO {
    Account getAccountById(final int id);
    Account getAccountByLoginPassword(String login, String password);
    ROLE getRoleByLogin(String login, String password);
    boolean accountIsExist(String login, String password);
    boolean addNewAccount(Account account);
    boolean updateAccount(Account account, int cash);
}
