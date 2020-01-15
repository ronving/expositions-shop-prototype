package com.ronving.model;

import java.util.Date;

public class Hall {
    private int id;
    private String theme;
    private int ticketPrice;
    private Date dateFrom;
    private Date dateTo;

    public Hall() {
    }

    public Hall(int id, String theme, int ticketPrice, Date dateFrom, Date dateTo) {
        this.id = id;
        this.theme = theme;
        this.ticketPrice = ticketPrice;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
