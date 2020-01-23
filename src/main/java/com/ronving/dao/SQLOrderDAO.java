package com.ronving.dao;

import com.ronving.dao.interfaces.OrderDAO;
import com.ronving.model.Account;
import com.ronving.model.Hall;
import com.ronving.model.Order;

import java.util.List;

public class SQLOrderDAO implements OrderDAO {
    private DataSourceManager dataSourceManager;

    private static String SAVE_ORDER = "";

    public SQLOrderDAO() {
        dataSourceManager = DataSourceManager.getInstance();
    }


    @Override
    public List<Order> getOrders(Account account) {
        return null;
    }

    @Override
    public boolean saveOrder(Order order, Hall hall, Account account) {
        return false;
    }
}
