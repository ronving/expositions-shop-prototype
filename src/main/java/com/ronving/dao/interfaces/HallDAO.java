package com.ronving.dao.interfaces;

import com.ronving.model.Hall;

import java.util.List;

/**
 * Hall Data Access Object interface
 */
public interface HallDAO {
    /**
     * Obtain all Halls from DB
     * @return list of Hall
     */
    List<Hall> findAll(int startFrom, int count);

    /**
     * Obtain Hall from DB
     * @param id of Hall to be obtain
     * @return list of Hall
     */
    Hall findHallById(int id);

    /**
     * Count Halls from DB for pagination
     * @return int value of records from DB table "halls"
     */
    int countRecords();

    /**
     * Create new Hall
     * @param hall new ExpoHall to be created in DB
     * @return boolean result of operation
     */
    boolean createHall(Hall hall);

    /**
     * Update Hall data in database
     * @param hall to be updated
     * @return boolean result of operation
     */
    boolean updateHall(Hall hall);

    /**
     * Delete Hall from database
     * @param id of Hall to be deleted
     * @return boolean result of operation
     */
    boolean deleteHall(int id);
}
