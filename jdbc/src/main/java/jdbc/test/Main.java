package jdbc.test;
import java.sql.*;

public class Main {


    public static void main(String[] args) {


        UsersDao usersDao = new UsersDao();

        usersDao.findAll();

        User newbie = new User(3456, "Ivan");

        //usersDao.update(newbie);
    }
}

