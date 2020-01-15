package com.ronving.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDataSourceManager {
    Connection getConnection() throws SQLException;
}
