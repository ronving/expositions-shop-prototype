package com.ronving.model;

import java.util.Date;

public class Order {
    private int orderKey;
    private Date dateValid;
    private int hallId;
    private String hallTheme;

    /**
     * default Order constructor.
     */
    public Order() {
    }

    /**
     * Order constructor for all params.
     */
    public Order(Date dateValid, int hallId, String hallTheme) {
        this.dateValid = dateValid;
        this.hallId = hallId;
        this.hallTheme = hallTheme;
    }

    /**
     * Getter for Order key
     *
     * @return orderKey
     */
    public int getOrderKey() {
        return orderKey;
    }

    /**
     * Setter for Order key
     *
     * @param orderKey
     */
    public void setOrderKey(int orderKey) {
        this.orderKey = orderKey;
    }

    /**
     * Getter for Order date valid
     *
     * @return dateValid
     */
    public Date getDateValid() {
        return dateValid;
    }

    /**
     * Setter for Order date valid
     *
     * @param dateValid
     */
    public void setDateValid(Date dateValid) {
        this.dateValid = dateValid;
    }

    /**
     * Getter for Order hall id
     *
     * @return hallId
     */
    public int getHallId() {
        return hallId;
    }

    /**
     * Setter for Hall id
     *
     * @param hallId primary identifier
     */
    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    /**
     * Getter for Hall theme
     *
     * @return hallTheme
     */
    public String getHallTheme() {
        return hallTheme;
    }

    /**
     * Setter for Hall theme
     *
     * @param hallTheme
     */
    public void setHallTheme(String hallTheme) {
        this.hallTheme = hallTheme;
    }
}
