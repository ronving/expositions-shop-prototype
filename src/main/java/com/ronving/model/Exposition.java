package com.ronving.model;

public class Exposition {
    private int id;
    private int hallId;
    private String title;
    private String theme;
    private String description;
    private String imgURL;

    /**
     * default Expo constructor.
     */
    public Exposition() {
    }

    /**
     * Expo constructor for all fields.
     */
    public Exposition(int id, int hallId, String title, String theme, String description, String imgURL) {
        this.id = id;
        this.hallId = hallId;
        this.title = title;
        this.theme = theme;
        this.description = description;
        this.imgURL = imgURL;
    }

    /**
     * Getter for Expo id
     *
     * @return id primary identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for Expo id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for hall id
     *
     * @return hallId primary identifier
     */
    public int getHallId() {
        return hallId;
    }

    /**
     * Setter for hall id
     *
     * @param hallId
     */
    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    /**
     * Getter for Expo title
     *
     * @return Expo title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for Expo title
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for Expo theme
     *
     * @return Expo theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Setter for Expo Theme
     *
     * @param theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Getter for Expo description
     *
     * @return Expo description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for Expo description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for Expo Img
     *
     * @return Expo img
     */
    public String getImgURL() {
        return imgURL;
    }

    /**
     * Setter for Expo Img
     *
     * @param imgURL
     */
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

}
