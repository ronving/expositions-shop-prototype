package com.ronving.model.builders;

import com.ronving.model.Exposition;

/**
 * Exposition Builder
 */
public class ExpositionBuilder {
    private Exposition exposition = new Exposition();

    public ExpositionBuilder setId(int id) {
        exposition.setId(id);
        return this;
    }

    public ExpositionBuilder setHallId(int hallId) {
        exposition.setHallId(hallId);
        return this;
    }

    public ExpositionBuilder setTitle(String title) {
        exposition.setTitle(title);
        return this;
    }

    public ExpositionBuilder setTheme(String theme) {
        exposition.setTheme(theme);
        return this;
    }

    public ExpositionBuilder setDescription(String description) {
        exposition.setDescription(description);
        return this;
    }

    public ExpositionBuilder setImgURL(String imgURL) {
        exposition.setImgURL(imgURL);
        return this;
    }

    /**
     * @return new Exposition
     */
    public Exposition build() {
        return exposition;
    }
}
