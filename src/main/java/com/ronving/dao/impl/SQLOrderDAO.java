package com.ronving.dao.impl;

import com.ronving.dao.DataSourceManager;
import com.ronving.dao.interfaces.OrderDAO;
import com.ronving.model.Account;
import com.ronving.model.Order;
import com.ronving.model.builders.OrderBuilder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLOrderDAO implements OrderDAO {
    private static final Logger LOGGER = Logger.getLogger(SQLOrderDAO.class);
    private static SQLOrderDAO instance;
    private DataSourceManager dataSourceManager;

    private static String FIND_ORDERS = "SELECT * from orders WHERE account_id=?";
    private static String SAVE_ORDER = "INSERT INTO orders(account_id,hall_id,date_valid,hall_theme) VALUES(?,?,?,?)";

    private SQLOrderDAO() {
        dataSourceManager = DataSourceManager.getInstance();
    }

    public static SQLOrderDAO getInstance() {
        if (instance == null) {
            instance = new SQLOrderDAO();
        }
        return instance;
    }

    @Override
    public List<Order> getOrders(Account account) {

        List<Order> orders = new ArrayList<>();
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ORDERS);
            preparedStatement.setInt(1, account.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(buildOrder(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return orders;
    }

    @Override
    public boolean saveOrder(Order order, Account account) {
        boolean saved = false;
        try (Connection connection = dataSourceManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_ORDER)) {
            prepareOrder(preparedStatement, order, account.getId());
            preparedStatement.executeUpdate();
            saved = true;
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return saved;
    }

    private void prepareOrder(PreparedStatement preparedStatement, Order order, int id) throws SQLException {
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, order.getHallId());
        preparedStatement.setDate(3, (Date) order.getDateValid());
        preparedStatement.setString(4, order.getHallTheme());
    }

    private Order buildOrder(ResultSet resultSet) throws SQLException {
        Order order = new OrderBuilder().setOrderKey(resultSet.getInt("order_key"))
                .setDateValid(resultSet.getDate("date_valid"))
                .setHallId(resultSet.getInt("hall_id"))
                .setHallTheme(resultSet.getString("hall_theme"))
                .build();
        return order;
    }
}
