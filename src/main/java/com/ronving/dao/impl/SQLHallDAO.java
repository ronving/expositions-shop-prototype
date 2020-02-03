package com.ronving.dao.impl;

import com.ronving.dao.DataSourceManager;
import com.ronving.dao.interfaces.HallDAO;
import com.ronving.model.Hall;
import com.ronving.model.builders.HallBuilder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLHallDAO implements HallDAO {
    private static SQLHallDAO instance;
    private DataSourceManager dataSourceManager;

    final static Logger LOGGER = Logger.getLogger(SQLHallDAO.class);

    private static String FIND_ALL = "SELECT * FROM halls LIMIT ?,?";
    private static String FIND_HALL = "SELECT * FROM halls WHERE id=?";
    private static String COUNT_RECORDS = "SELECT COUNT(*) FROM halls";
    private static String CREATE_HALL = "INSERT INTO halls(theme, ticket_price, date_from, date_to, img, description) VALUES(?,?,?,?,?,?)";
    private static final String UPDATE_HALL = "UPDATE halls SET theme = ?, ticket_price = ?, date_from = ?, date_to = ?, img = ?, description=? WHERE id = ?";
    private static final String DELETE_HALL = "DELETE FROM halls WHERE id = ?";

    private SQLHallDAO() {
        dataSourceManager = DataSourceManager.getInstance();
    }

    public static SQLHallDAO getInstance() {
        if (instance == null) {
            instance = new SQLHallDAO();
        }
        return instance;
    }

    @Override
    public List<Hall> findAll(int startFrom, int count) {
        List<Hall> halls = new ArrayList<>();
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            preparedStatement.setInt(1, startFrom);
            preparedStatement.setInt(2, count);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                halls.add(buildHall(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return halls;
    }

    @Override
    public Hall findHallById(int id) {
        Hall hall = new Hall();
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_HALL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                hall = buildHall(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return hall;
    }

    @Override
    public int countRecords() {
        int count = 0;
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(COUNT_RECORDS);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return count;
    }

    @Override
    public boolean createHall(Hall hall) {

        boolean created = false;
        try (Connection connection = dataSourceManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_HALL)) {
            prepareHall(preparedStatement, hall);
            preparedStatement.executeUpdate();
            created = true;
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return created;
    }

    @Override
    public boolean updateHall(Hall hall) {
        boolean updated = false;
        try (Connection connection = dataSourceManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HALL)) {
            prepareHall(preparedStatement, hall);
            preparedStatement.setInt(7, hall.getId());
            preparedStatement.executeUpdate();
            updated = true;
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return updated;
    }

    @Override
    public boolean deleteHall(int id) {
        boolean deleted = false;
        try (Connection connection = dataSourceManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_HALL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            deleted = true;
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return deleted;
    }

    private Hall buildHall(ResultSet resultSet) throws SQLException {
        Hall hall = new HallBuilder()
                .setId(resultSet.getInt("id"))
                .setTheme(resultSet.getString("theme"))
                .setTicketPrice(resultSet.getInt("ticket_price"))
                .setDateFrom(resultSet.getDate("date_from"))
                .setDateTo(resultSet.getDate("date_to"))
                .setImgURL(resultSet.getString("img"))
                .setDescription(resultSet.getString("description"))
                .build();
        return hall;
    }

    private void prepareHall(PreparedStatement preparedStatement, Hall hall) throws SQLException {
        preparedStatement.setString(1, hall.getTheme());
        preparedStatement.setInt(2, hall.getTicketPrice());
        preparedStatement.setDate(3, (Date) hall.getDateFrom());
        preparedStatement.setDate(4, (Date) hall.getDateTo());
        preparedStatement.setString(5, hall.getImgURL());
        preparedStatement.setString(6, hall.getDescription());
    }
}
