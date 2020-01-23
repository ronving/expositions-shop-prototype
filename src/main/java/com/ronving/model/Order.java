package com.ronving.model;

import java.util.Date;

public class Order {
    private int orderKey;
    private Date dateValid;

    public Order() {
    }

    public Order(int orderKey, Date dateValid) {
        this.orderKey = orderKey;
        this.dateValid = dateValid;
    }

    public int getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(int orderKey) {
        this.orderKey = orderKey;
    }

    public Date getDateValid() {
        return dateValid;
    }

    public void setDateValid(Date dateValid) {
        this.dateValid = dateValid;
    }
}
