package ru.itis.dao;

import ru.itis.model.Auto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoDaoJdbcImpl implements AutoDao {

    //region SQL queries here <-----------------------
    // language=SQL
    private static final String SELECT_FROM_CARS = "SELECT * FROM cars;";

    // language=SQL
    private static final String SQL_SELECT_AUTO_BY_ID = "SELECT * FROM cars WHERE id = ?;";

    // language=SQL
    private static final String SQL_SELECT_AUTO_BY_OWNER_ID ="SELECT * FROM cars WHERE owner_id = ?;";

    // language=SQL
    private static final String SQL_INSERT_AUTO = "INSERT INTO cars(id, owner_id, model, mileage) VALUES(?, ?, ?, ?);";

    // language=SQL
    private static final String SQL_DELETE_AUTO = "DELETE FROM cars WHERE id = ?;";

    // language=SQL
    private static final String SQL_UPDATE_AUTO = "UPDATE cars SET owner_id=?, model=?, mileage=? WHERE id = ?;";


    //endregion

    private Connection connection;

    public AutoDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Auto> findAll() {
        List<Auto> autos = new ArrayList<Auto>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_CARS);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int owner_id = resultSet.getInt("owner_id");
                int mileage = resultSet.getInt("mileage");
                String model = resultSet.getString("model");
                autos.add(new Auto.Builder()
                        .setId(id)
                        .setOwnerId(owner_id)
                        .setModel(model)
                        .setMileage(mileage)
                        .build()
                );
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return autos;
    }

    public Auto find(int id) {
        Auto auto = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_AUTO_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int carid = resultSet.getInt("id");
                int owner_id = resultSet.getInt("owner_id");
                int mileage = resultSet.getInt("mileage");
                String model = resultSet.getString("model");
                auto = new Auto.Builder()
                        .setId(id)
                        .setOwnerId(owner_id)
                        .setModel(model)
                        .setMileage(mileage)
                        .build();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return auto;
    }

    public void save(Auto auto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_AUTO);
            preparedStatement.setInt(1, auto.getId());
            preparedStatement.setInt(2, auto.getOwnerId());
            preparedStatement.setString(3, auto.getModel());
            preparedStatement.setInt(4, auto.getMileage());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_AUTO);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    public void update(Auto auto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_AUTO);
            preparedStatement.setInt(1, auto.getOwnerId());
            preparedStatement.setString(2, auto.getModel());
            preparedStatement.setInt(3, auto.getMileage());
            preparedStatement.setInt(4, auto.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    public List<Auto> findAllCarsByOwnerId(int ownerId) {
        List<Auto> autos = new ArrayList<Auto>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_AUTO_BY_OWNER_ID);
            preparedStatement.setInt(1, ownerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int owner_id = resultSet.getInt("owner_id");
                int mileage = resultSet.getInt("mileage");
                String model = resultSet.getString("model");
                autos.add(new Auto.Builder()
                        .setId(id)
                        .setOwnerId(owner_id)
                        .setModel(model)
                        .setMileage(mileage)
                        .build()
                );
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return autos;
    }

}
