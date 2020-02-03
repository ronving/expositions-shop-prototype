package com.ronving.model.builders;


import com.ronving.model.Hall;

import java.util.Date;

/**
 * Hall Builder
 */
public class HallBuilder {
    private Hall hall = new Hall();

    public HallBuilder setId(int id) {
        hall.setId(id);
        return this;
    }

    public HallBuilder setTheme(String theme) {
        hall.setTheme(theme);
        return this;
    }

    public HallBuilder setTicketPrice(int ticketPrice) {
        hall.setTicketPrice(ticketPrice);
        return this;
    }

    public HallBuilder setDateFrom(Date dateFrom) {
        hall.setDateFrom(dateFrom);
        return this;
    }

    public HallBuilder setDateTo(Date dateTo) {
        hall.setDateTo(dateTo);
        return this;
    }

    public HallBuilder setImgURL(String imgURL) {
        hall.setImgURL(imgURL);
        return this;
    }

    public HallBuilder setDescription(String description) {
        hall.setDescription(description);
        return this;
    }

    /**
     * @return new Hall
     */
    public Hall build() {
        return hall;
    }
}
