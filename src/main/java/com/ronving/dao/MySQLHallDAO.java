package com.ronving.dao;

import com.ronving.dao.interfaces.HallDAO;
import com.ronving.model.Hall;
import com.ronving.model.builders.HallBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLHallDAO implements HallDAO {
    private DataSourceManager dataSourceManager;

    private static String FIND_ALL = "SELECT * FROM halls";
    private static String FIND_HALL = "SELECT * FROM halls WHERE id=?";
    private static String CREATE_HALL = "INSERT INTO halls(theme, ticket_price date_from, date_to) VALUES(?,?,?,?)";
    private static final String UPDATE_HALL = "UPDATE halls SET theme = ?, ticket_price = ?, date_from = ?, date_to = ? WHERE id = ?";
    private static final String DELETE_HALL = "DELETE FROM halls WHERE id = ?";

    public MySQLHallDAO() {
        dataSourceManager = DataSourceManager.getInstance();
    }

    @Override
    public List<Hall> findAll() {
        List<Hall> halls = new ArrayList<>();
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                halls.add(buildHall(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return halls;
    }

    @Override
    public Hall findHallById(int id) {
        Hall hall = new Hall();
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_HALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                hall = buildHall(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hall;
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
            e.printStackTrace();
        }
        return created;
    }

    @Override
    public boolean updateHall(Hall hall) {
        boolean updated = false;
        try (Connection connection = dataSourceManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HALL)) {
            prepareHall(preparedStatement, hall);
            preparedStatement.setInt(5, hall.getId());
            preparedStatement.executeUpdate();
            updated = true;
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
                .build();
        return hall;
    }

    private void prepareHall(PreparedStatement preparedStatement, Hall hall) throws SQLException {
        preparedStatement.setString(1, hall.getTheme());
        preparedStatement.setInt(2, hall.getTicketPrice());
        preparedStatement.setDate(3, (Date) hall.getDateFrom());
        preparedStatement.setDate(4, (Date) hall.getDateTo());
    }
}
