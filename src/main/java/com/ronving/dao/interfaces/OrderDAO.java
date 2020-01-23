package com.ronving.dao.interfaces;

import com.ronving.model.Account;
import com.ronving.model.Hall;
import com.ronving.model.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getOrders(Account account);
    boolean saveOrder(Order order, Hall hall, Account account);
}
