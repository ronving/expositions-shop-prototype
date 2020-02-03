package com.ronving.model;

import java.util.Date;

public class Order {
    private int orderKey;
    private Date dateValid;
    private int hallId;
    private String hallTheme;

    public Order() {
    }

    public Order(Date dateValid, int hallId, String hallTheme) {
        this.dateValid = dateValid;
        this.hallId = hallId;
        this.hallTheme = hallTheme;
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

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getHallTheme() {
        return hallTheme;
    }

    public void setHallTheme(String hallTheme) {
        this.hallTheme = hallTheme;
    }
}
