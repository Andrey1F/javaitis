package dbcon.factories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory instance;

    private Connection connection;

    private Properties properties;

    static {
        instance = new ConnectionFactory();
    }

    private ConnectionFactory() throws InstantiationException {
        properties = new Properties();
        try {
            properties.load(new
                    FileInputStream("C:\\Code\\javaitis\\myjdbc\\src\\main\\resources"));
            String driverName = properties.getProperty("database.driver");
            String url = properties.getProperty("database.url");
            String name = properties.getProperty("database.name");
            String password = properties.getProperty("database.password");

            Class.forName(driverName);
            connection = DriverManager.getConnection(url, name, password);


        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionFactory getInstance() {
        return instance;
    }
}


