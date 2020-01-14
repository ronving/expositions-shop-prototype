package com.ronving.model;

import java.net.URL;

public class Exposition {
    private int id;
    private int hallId;
    private String title;
    private String theme;
    private String description;
//    private URL picture;

    public Exposition() {
    }

    public Exposition(int id, int hallId, String title, String theme, String description, URL image) {
        this.id = id;
        this.hallId = hallId;
        this.title = title;
        this.theme = theme;
        this.description = description;
//        this.picture = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public URL getPicture() {
//        return picture;
//    }
//
//    public void setPicture(URL picture) {
//        this.picture = picture;
//    }
}
