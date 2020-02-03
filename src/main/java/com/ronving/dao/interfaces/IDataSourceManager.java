package com.ronving.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDataSourceManager {

    /**
     * @return new Connection
     * @throws SQLException
     */
    Connection getConnection() throws SQLException;
}
