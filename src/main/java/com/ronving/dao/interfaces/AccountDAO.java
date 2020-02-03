package com.ronving.dao.interfaces;

import com.ronving.model.roles.ROLE;
import com.ronving.model.Account;

/**
 * Account Data Access Object interface
 */
public interface AccountDAO {
    Account getAccountById(final int id);

    /**
     * @param login Account's login
     * @param password Account's password
     * @return Account found in database with requested login and password
     */
    Account getAccountByLoginPassword(String login, String password);

    /**
     * @param login Account's login
     * @param password Account's password
     * @return Account`s ROLE found in database with requested login and password
     */
    ROLE getRoleByLogin(String login, String password);

    /**
     * @param login requested
     * @return boolean result depending on account with this login exist's in database
     */
    boolean accountIsExist(String login, String password);

    /**
     * @param account will be created in database
     * @return boolean result of transaction success
     */
    boolean addNewAccount(Account account);

    /**
     * @param account will be updated in database
     * @return boolean result of operation success
     */
    boolean updateAccount(Account account, int cash);
}
