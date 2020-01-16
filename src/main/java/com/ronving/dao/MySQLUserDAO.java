package com.ronving.dao;

import com.ronving.dao.interfaces.IDataSourceManager;
import com.ronving.dao.interfaces.UserDAO;
import com.ronving.model.Account;
import com.ronving.model.roles.ROLE;

import java.sql.*;

public class MySQLUserDAO implements UserDAO {
    private IDataSourceManager dataSourceManager;

    private static final String FIND_ACCOUNT = "SELECT * FROM accounts WHERE login=? AND password=?";
    private static final String FIND_LOGIN = "SELECT * FROM accounts WHERE login=?";
    private static final String GET_ROLE = "SELECT * FROM accounts WHERE login=?";
    private static final String CREATE_ACCOUNT = "INSERT INTO accounts" + "(id,login,password,balance,role) " + "VALUES(?,?,?,?,?)";

    public MySQLUserDAO() {
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
                account.setId(resultSet.getInt("id"));
                account.setLogin(resultSet.getString("login"));
                account.setPassword(resultSet.getString("password"));
                account.setRole();
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                String result = resultSet.getString("role");
                if (result.equals("USER")) {
                    role = ROLE.USER;
                } else if (result.equals("ADMIN")) {
                    role = ROLE.ADMIN;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
                e.printStackTrace();
            }
        } finally {
            try {

                if (preparedAccount != null) {
                    preparedAccount.close();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return created;
    }

    private void prepareAccount(PreparedStatement preparedAccount, Account account) throws SQLException {

        preparedAccount.setInt(1, account.getId());
        preparedAccount.setString(2, account.getLogin());
        preparedAccount.setString(3, account.getPassword());
        preparedAccount.setInt(4, account.getBalance());
        preparedAccount.setString(5, account.getRole().getString());
    }
}
