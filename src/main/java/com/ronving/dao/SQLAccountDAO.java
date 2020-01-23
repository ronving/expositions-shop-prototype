package com.ronving.dao;

import com.ronving.dao.interfaces.IDataSourceManager;
import com.ronving.dao.interfaces.AccountDAO;
import com.ronving.model.Account;
import com.ronving.model.builders.AccountBuilder;
import com.ronving.model.roles.ROLE;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLAccountDAO implements AccountDAO {
    private IDataSourceManager dataSourceManager;

    final static Logger LOGGER = Logger.getLogger(SQLAccountDAO.class);

    private static final String FIND_ACCOUNT = "SELECT * FROM accounts WHERE login=? AND password=?";
    private static final String FIND_LOGIN = "SELECT * FROM accounts WHERE login=?";
    private static final String GET_ROLE = "SELECT * FROM accounts WHERE login=?";
    private static final String CREATE_ACCOUNT = "INSERT INTO accounts(id,login,password,balance,role) VALUES(?,?,?,?,?)";

    public SQLAccountDAO() {
        this.dataSourceManager = DataSourceManager.getInstance();
    }

    @Override
    public Account getUserById(int id) {
        return null;
    }

    @Override
    public Account getUserByLoginPassword(String login, String password) {
        Account account = new Account();
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ACCOUNT);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = buildAccount(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return account;
    }

    @Override
    public ROLE getRoleByLogin(String login, String password) {
        ROLE role = ROLE.UNKNOWN;
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
//                String result = resultSet.getString("role");
//                if (result.equals("USER")) {
//                    role = ROLE.USER;
//                } else if (result.equals("ADMIN")) {
//                    role = ROLE.ADMIN;
//                }
                role = identifyRole(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return role;
    }

    @Override
    public boolean userIsExist(String login, String password) {
        boolean isExist = false;
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            isExist = resultSet.next();
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return isExist;
    }

    @Override
    public boolean addNewUser(Account account) {
        boolean created = false;
        PreparedStatement preparedAccount = null;
        Connection connection = null;
        try {
            connection = dataSourceManager.getConnection();
            preparedAccount = connection.prepareStatement(CREATE_ACCOUNT);
            connection.setAutoCommit(false);
            prepareAccount(preparedAccount, account);
            preparedAccount.executeUpdate();
            connection.commit();
            created = true;
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException sqlExc) {
                LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
            }
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        } finally {
            try {
                if (preparedAccount != null) {
                    preparedAccount.close();
                }
            } catch (SQLException e) {
                LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
            }

            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
            }
        }
        return created;
    }

    private ROLE identifyRole(ResultSet resultSet) throws SQLException {
        String result = resultSet.getString("role");
        if (result.equals("ADMIN")) {
            return ROLE.ADMIN;
        } else {
            return ROLE.USER;
        }
    }

    private void prepareAccount(PreparedStatement preparedAccount, Account account) throws SQLException {
        preparedAccount.setInt(1, account.getId());
        preparedAccount.setString(2, account.getLogin());
        preparedAccount.setString(3, account.getPassword());
        preparedAccount.setInt(4, account.getBalance());
        preparedAccount.setString(5, account.getRole().getString());
    }

    private Account buildAccount(ResultSet resultSet) throws SQLException {
        Account account = new AccountBuilder()
                .setId(resultSet.getInt("id"))
                .setLogin(resultSet.getString("login"))
                .setPassword(resultSet.getString("password"))
                .setRole().build();
        return account;
    }
}
