package com.ronving.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hall {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private int id;
    private String theme;
    private int ticketPrice;
    private Date dateFrom;
    private Date dateTo;
    private String imgURL;

    public Hall() {
    }

    public Hall(int id, String theme, int ticketPrice, Date dateFrom, Date dateTo, String imgURL) {
        this.id = id;
        this.theme = theme;
        this.ticketPrice = ticketPrice;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.imgURL = imgURL;
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

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
