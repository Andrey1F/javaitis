package ru.itis.dao;

import ru.itis.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoJdbcImpl implements UsersDao {

    private Connection connection;


    //<editor-fold desc="SQL expressions announcement <---------------">>
    // language=SQL
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM members;";

    // language=SQL
    private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM members WHERE id = ?;";

    // language=SQL
    private static final String SQL_INSERT_USER = "INSERT INTO members(id, name, age, city) VALUES(?, ?, ?, ?);";

    // language=SQL
    private static final String SQL_DELETE_USER = "DELETE FROM members WHERE id = ?;";

    // language=SQL
    private static final String SQL_UPDATE_USER = "UPDATE members SET name=?, age=?, city=? WHERE id = ?;";
    //</editor-fold>

    public  UsersDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<User>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String city = resultSet.getString("city");
                users.add(new User.Builder()
                        .setId(id)
                        .setName(name)
                        .setAge(age)
                        .setCity(city)
                        .build()
                );
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return users;
    }

    public User find(int id) {
        User user = null;

        try {
            int userid = 0;
            String name = "";
            int age = 0;
            String city = "";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userid = resultSet.getInt("id");
                name = resultSet.getString("name");
                age = resultSet.getInt("age");
                city = resultSet.getString("city");
                user = new User.Builder()
                        .setId(id)
                        .setName(name)
                        .setAge(age)
                        .setCity(city)
                        .build();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return user;
    }

    public long save (User user) {
        long lastInsertKey = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getCity());

            preparedStatement.execute();

            // find last insert ID
           /** ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            lastInsertKey = generatedKeys.getLong(1); */

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return lastInsertKey;
    }

    public void delete (int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void update(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getCity());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


}
