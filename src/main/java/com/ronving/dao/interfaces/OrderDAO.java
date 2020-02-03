package com.ronving.dao.interfaces;

import com.ronving.model.Account;
import com.ronving.model.Order;

import java.util.List;

/**
 * Order Data Access Object interface
 */
public interface OrderDAO {
    /**
     * Obtaining all order related to Account
     *
     * @param account with id which requested its orders
     * @return list of account's orders
     */
    List<Order> getOrders(Account account);

    /**
     * Saves new order in database
     *
     * @param order      new Order
     * @param account of holder`s of order
     * @return boolean result of operation
     */
    boolean saveOrder(Order order, Account account);
}
