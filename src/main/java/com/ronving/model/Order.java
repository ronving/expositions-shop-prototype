package com.ronving.model;

import java.util.Date;

public class Order {
    private String orderKey;
    private Date dateValid;

    public Order() {
    }

    public Order(String orderKey, Date dateValid) {
        this.orderKey = orderKey;
        this.dateValid = dateValid;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public Date getDateValid() {
        return dateValid;
    }

    public void setDateValid(Date dateValid) {
        this.dateValid = dateValid;
    }
}
