package com.ronving.dao.interfaces;

import com.ronving.model.Exposition;

import java.util.List;

/**
 * Exposition Data Access Object interface
 */
public interface ExpositionDAO {

    /**
     * Obtain all Expositions from database
     * @return list of Expositions
     */
    List<Exposition> findAll();

    /**
     * find Expositions corresponds to hall request
     * @param hallId hall primary identifier
     * @return list of Expositions
     */
    List<Exposition> findExpositionsByHall(int hallId);

    /**
     * @param exposition to be updated
     * @return boolean result of operation
     */
    boolean createExposition(Exposition exposition);

    /**
     * @param exposition to be updated
     * @return boolean result of operation
     */
    boolean updateExposition(Exposition exposition);

    /**
     * @param id of Exposition to be deleted
     * @return boolean result of operation
     */
    boolean deleteExposition(int id);
}
