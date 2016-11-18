package jdbc.test;

import java.sql.*;
import java.util.List;

public class UsersDao {

    // language=SQL
    private static final String SQL_SELECT_USER =
            "SELECT * FROM members;";

    // language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO members(id, name) VALUES(?, ?);";

    Connection connection = null;

    String url = "jdbc:postgresql://localhost:5432/postgres";

    String name = "postgres";
    String password = "password";

    //public UsersDao() {}

    public void findAll() {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_SELECT_USER);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "," + resultSet.getString("name"));
            }

        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }



    }


    public void update(User user){

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_SELECT_USER);



            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());

            preparedStatement.execute();
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

    }

}