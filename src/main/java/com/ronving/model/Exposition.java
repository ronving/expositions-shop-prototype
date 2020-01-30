package com.ronving.model;

public class Exposition {
    private int id;
    private int hallId;
    private String title;
    private String theme;
    private String description;
    private String imgURL;

    public Exposition() {
    }

    public Exposition(int id, int hallId, String title, String theme, String description, String imgURL) {
        this.id = id;
        this.hallId = hallId;
        this.title = title;
        this.theme = theme;
        this.description = description;
        this.imgURL = imgURL;
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

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return "Exposition{" +
                "id=" + id +
                ", hallId=" + hallId +
                ", title='" + title + '\'' +
                ", theme='" + theme + '\'' +
                ", description='" + description + '\'' +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}
