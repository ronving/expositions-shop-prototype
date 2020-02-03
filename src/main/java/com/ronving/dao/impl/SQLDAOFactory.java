package com.ronving.dao.impl;

import com.ronving.dao.interfaces.*;

public class SQLDAOFactory implements DAOFactory {
    @Override
    public SQLAccountDAO getAccountDAO() {
        return SQLAccountDAO.getInstance();
    }

    @Override
    public SQLHallDAO getHallDAO() {
        return SQLHallDAO.getInstance();
    }

    @Override
    public SQLExpositionDAO getExpositionDAO() {
        return SQLExpositionDAO.getInstance();
    }

    @Override
    public SQLOrderDAO getOrderDAO() {
        return SQLOrderDAO.getInstance();
    }
}
