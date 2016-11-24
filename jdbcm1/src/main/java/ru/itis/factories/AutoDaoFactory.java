package ru.itis.factories;

import ru.itis.dao.AutoDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.Properties;

public class AutoDaoFactory {

    // поле, которое хранит единственный экземпляр
    private static AutoDaoFactory instance;

    private AutoDao autoDao;

    private Properties properties;

    static {
        instance = new AutoDaoFactory();
    }

    private AutoDaoFactory() {
        properties = new Properties();
        try {
            properties.load(new
                    FileInputStream("C:\\Code\\projects\\jdbcm1\\src\\main\\resources\\application.properties"));

            String daoClassName = properties.getProperty("auto.dao.class");

            Constructor constructor = Class.forName(daoClassName).getConstructor(Connection.class);
            autoDao = (AutoDao)constructor.newInstance(ConnectionFactory.getInstance().getConnection());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public AutoDao getAutoDao() {
        return autoDao;
    }

    public static AutoDaoFactory getInstance() {
        return instance;
    }
}
