package com.ronving.dao.interfaces;

import com.ronving.model.Hall;

import java.util.List;

public interface HallDAO {
    List<Hall> findAll(int startFrom, int count);
    Hall findHallById(int id);
    int countRecords();
    boolean createHall(Hall hall);
    boolean updateHall(Hall hall);
    boolean deleteHall(int id);
}
