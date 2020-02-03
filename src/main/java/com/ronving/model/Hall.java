package com.ronving.model;

import java.util.Date;

public class Hall {

    private int id;
    private String theme;
    private int ticketPrice;
    private Date dateFrom;
    private Date dateTo;
    private String imgURL;
    private String description;

    /**
     * default Hall constructor.
     */
    public Hall() {
    }

    /**
     * Hall constructor with all params.
     */
    public Hall(int id, String theme, int ticketPrice, Date dateFrom, Date dateTo, String imgURL, String description) {
        this.id = id;
        this.theme = theme;
        this.ticketPrice = ticketPrice;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.imgURL = imgURL;
        this.description = description;
    }

    /**
     * Getter for Hall id
     *
     * @return id primary identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for Hall id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for Hall theme
     *
     * @return Hall theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Setter for Hall Theme
     *
     * @param theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Getter for ticket price
     *
     * @return ticket price
     */
    public int getTicketPrice() {
        return ticketPrice;
    }

    /**
     * Setter for ticket price
     *
     * @param ticketPrice
     */
    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /**
     * Getter for date of begin
     *
     * @return dateFrom
     */
    public Date getDateFrom() {
        return dateFrom;
    }

    /**
     * Setter for date of begin
     *
     * @param dateFrom
     */
    public void setDateFrom(Date dateFrom) {
            this.dateFrom = dateFrom;
    }

    /**
     * Getter for date of end
     *
     * @return dateTo
     */
    public Date getDateTo() {
        return dateTo;
    }

    /**
     * Setter for date of end
     *
     * @param dateTo
     */
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * Getter for Hall img
     *
     * @return imgURL
     */
    public String getImgURL() {
        return imgURL;
    }

    /**
     * Setter for Hall img
     *
     * @param imgURL
     */
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    /**
     * Getter for Hall description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for Hall description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
