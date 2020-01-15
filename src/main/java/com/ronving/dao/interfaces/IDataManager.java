package com.ronving.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDataManager {
    Connection createConnection() throws SQLException;
    void closeConnection(Connection connection);
}
