package com.ronving.dao.impl;

import com.ronving.model.Exposition;
import com.ronving.model.builders.ExpositionBuilder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLExpositionDAO implements com.ronving.dao.interfaces.ExpositionDAO {
    private static SQLExpositionDAO instance;
    private DataSourceManager dataSourceManager;

    final static Logger LOGGER = Logger.getLogger(SQLExpositionDAO.class);

    private static String FIND_ALL = "SELECT * FROM expositions";
    private static String FIND_THEMES = "SELECT DISTINCT theme FROM expositions";
    private static String FIND_EXPOSITION = "SELECT * FROM expositions WHERE hall_id=?";
    private static String CREATE_EXPOSITION = "INSERT INTO expositions(hall_id, title, theme, description, img) VALUES(?,?,?,?,?)";
    private static final String UPDATE_EXPOSITION = "UPDATE expositions SET hall_id = ?, title = ?, theme = ?, description = ?, img = ? WHERE id = ?";
    private static final String DELETE_EXPOSITION = "DELETE FROM expositions WHERE id = ?";

    private SQLExpositionDAO() {
        dataSourceManager = DataSourceManager.getInstance();
    }

    public static SQLExpositionDAO getInstance() {
        if (instance == null) {
            instance = new SQLExpositionDAO();
        }
        return instance;
    }

    @Override
    public List<Exposition> findAll() {
        List<Exposition> expositions = new ArrayList<>();
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                expositions.add(buildExposition(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return expositions;
    }

    @Override
    public Exposition findExposition(String query) {
        return null;
    }

    @Override
    public List<String> findThemes() {
        List<String> themes = new ArrayList<>();
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_THEMES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                themes.add(resultSet.getString("theme"));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return themes;
    }

    @Override
    public List<Exposition> findExpositionsByHall(int hallId) {
        List<Exposition> expositions = new ArrayList<>();
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_EXPOSITION);
            preparedStatement.setInt(1, hallId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                expositions.add(buildExposition(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return expositions;
    }

    @Override
    public boolean createExposition(Exposition exposition) {
        boolean created = false;
        try (Connection connection = dataSourceManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EXPOSITION)) {
            prepareExposition(preparedStatement, exposition);
            preparedStatement.executeUpdate();
            created = true;
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return created;
    }

    @Override
    public boolean updateExposition(Exposition exposition) {
        boolean updated = false;
        try (Connection connection = dataSourceManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EXPOSITION)) {
            prepareExposition(preparedStatement, exposition);
            preparedStatement.setInt(6, exposition.getId());
            preparedStatement.executeUpdate();
            updated = true;
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return updated;
    }

    @Override
    public boolean deleteExposition(int id) {
        boolean deleted = false;
        try (Connection connection = dataSourceManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EXPOSITION)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            deleted = true;
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQL Exception occured in " + getClass().getSimpleName(), e);
        }
        return deleted;
    }

    private Exposition buildExposition(ResultSet resultSet) throws SQLException {
        Exposition exposition = new ExpositionBuilder()
                .setId(resultSet.getInt("id"))
                .setHallId(resultSet.getInt("hall_id"))
                .setTitle(resultSet.getString("title"))
                .setTheme(resultSet.getString("theme"))
                .setDescription(resultSet.getString("description"))
                .setImgURL(resultSet.getString("img"))
                .build();
        return exposition;
    }

    private void prepareExposition(PreparedStatement preparedStatement, Exposition exposition) throws SQLException {
        preparedStatement.setInt(1, exposition.getHallId());
        preparedStatement.setString(2, exposition.getTitle());
        preparedStatement.setString(3, exposition.getTheme());
        preparedStatement.setString(4, exposition.getDescription());
        preparedStatement.setString(5, exposition.getImgURL());
    }
}
