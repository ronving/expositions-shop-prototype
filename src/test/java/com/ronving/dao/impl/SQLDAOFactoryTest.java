package com.ronving.dao.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SQLDAOFactoryTest {

    private static SQLDAOFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new SQLDAOFactory();
    }

    @Test
    public void getAccountDAO() {
        SQLAccountDAO expected = SQLAccountDAO.getInstance();
        SQLAccountDAO actual = factory.getAccountDAO();
        assertEquals(expected, actual);
    }

    @Test
    public void getHallDAO() {
        SQLHallDAO expected = SQLHallDAO.getInstance();
        SQLHallDAO actual = factory.getHallDAO();
        assertEquals(expected, actual);
    }

    @Test
    public void getExpositionDAO() {
        SQLExpositionDAO expected = SQLExpositionDAO.getInstance();
        SQLExpositionDAO actual = factory.getExpositionDAO();
        assertEquals(expected, actual);
    }

    @Test
    public void getOrderDAO() {
        SQLOrderDAO expected = SQLOrderDAO.getInstance();
        SQLOrderDAO actual = factory.getOrderDAO();
        assertEquals(expected, actual);
    }
}