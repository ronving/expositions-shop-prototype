package com.ronving.dao;

import com.ronving.dao.interfaces.ExpositionDAO;
import com.ronving.model.Exposition;
import com.ronving.model.builders.ExpositionBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLExpositionDAO implements ExpositionDAO {
    private DataSourceManager dataSourceManager;

    private static String FIND_ALL = "SELECT * FROM expositions";
    private static String FIND_THEMES = "SELECT DISTINCT theme FROM expositions";
    private static String FIND_EXPOSITION = "SELECT * FROM expositions WHERE theme=?";
    private static String CREATE_EXPOSITION = "INSERT INTO expositions(hall_id, title, theme, description) VALUES(?,?,?,?)";
    private static final String UPDATE_EXPOSITION = "UPDATE expositions SET hall_id = ?, title = ?, theme = ?, description = ? WHERE id = ?";
    private static final String DELETE_EXPOSITION = "DELETE FROM expositions WHERE id = ?";

    public SQLExpositionDAO() {
        dataSourceManager = DataSourceManager.getInstance();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return themes;
    }

    @Override
    public List<Exposition> findExpositionsByTheme() {
        List<Exposition> expositions = new ArrayList<>();
        try (Connection connection = dataSourceManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_EXPOSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                expositions.add(buildExposition(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return created;
    }

    @Override
    public boolean updateExposition(Exposition exposition) {
        boolean updated = false;
        try (Connection connection = dataSourceManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EXPOSITION)) {
            prepareExposition(preparedStatement, exposition);
            preparedStatement.setInt(5, exposition.getId());
            preparedStatement.executeUpdate();
            updated = true;
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
                .build();
        return exposition;
    }

    private void prepareExposition(PreparedStatement preparedStatement, Exposition exposition) throws SQLException {
        preparedStatement.setInt(1, exposition.getHallId());
        preparedStatement.setString(2, exposition.getTitle());
        preparedStatement.setString(3, exposition.getTheme());
        preparedStatement.setString(4, exposition.getDescription());
    }
}
