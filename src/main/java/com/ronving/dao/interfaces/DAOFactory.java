package com.ronving.dao.interfaces;

public interface DAOFactory {
    /**
     * @return instance of concrete AccountDAO implementation.
     */
    public AccountDAO getAccountDAO();

    /**
     * @return instance of concrete HallDAO implementation.
     */
    public HallDAO getHallDAO();
    /**
     * @return instance of concrete ExpositionDAO implementation.
     */
    public ExpositionDAO getExpositionDAO();
    /**
     * @return instance of concrete OrderDAO implementation.
     */
    public OrderDAO getOrderDAO();
}
