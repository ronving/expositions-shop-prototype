package com.ronving.dao.interfaces;

import com.ronving.model.Hall;
import com.ronving.model.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getOrders(int userId);
    boolean saveOrder(Order order, Hall hall, int userId);
}
