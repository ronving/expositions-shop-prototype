package com.ronving.dao.interfaces;

import com.ronving.model.Exposition;

import java.util.List;

public interface ExpositionDAO {
    List<Exposition> findAll();
    Exposition findExposition(String query);
    List<String> findThemes();
    List<Exposition> findExpositionsByTheme(String query);
    boolean createExposition(Exposition exposition);
    boolean updateExposition(Exposition exposition);
    boolean deleteExposition(int id);
}
