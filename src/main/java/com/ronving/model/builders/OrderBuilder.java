package com.ronving.model.builders;

import com.ronving.model.Order;

import java.util.Date;

public class OrderBuilder {
    private Order order = new Order();

    public OrderBuilder setOrderKey(int orderKey) {
        order.setOrderKey(orderKey);
        return this;
    }

    public OrderBuilder setDateValid(Date dateValid) {
        order.setDateValid(dateValid);
        return this;
    }

    public OrderBuilder setHallId(int hallId) {
        order.setHallId(hallId);
        return this;
    }

    public OrderBuilder setHallTheme(String hallTheme) {
        order.setHallTheme(hallTheme);
        return this;
    }

    public Order build() {
        return order;
    }
}
