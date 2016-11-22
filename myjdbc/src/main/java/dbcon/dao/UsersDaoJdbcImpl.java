package dbcon.dao;

import dbcon.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UsersDaoJdbcImpl implements UsersDao {

    // language=SQL
    private static final String SQL_SELECT_USER =
            "SELECT * FROM members;";

    private Connection connection;
    public UsersDaoJdbcImpl (Connection connection){

        this.connection = connection;

    }
    public List<User> finaAll() {

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_USER);

            List<User> resultList = new ArrayList<User>();

            while (resultSet.next()) {

                int userId = resultSet.getInt("id");
                String userName = resultSet.getString("name");
                User user = new User(userId, userName);
                addUser(user);

            }
            return resultList;

        } catch (SQLException e) {
            throw new IllegalStateException();
        }






    }
}
