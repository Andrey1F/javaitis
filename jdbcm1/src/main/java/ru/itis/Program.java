package ru.itis;

import ru.itis.dao.UsersDao;
import ru.itis.dao.UsersDaoJdbcImpl;
import ru.itis.factories.DaoFactory;
import ru.itis.factories.ServiceFactory;
import ru.itis.model.Auto;
import ru.itis.model.User;
import ru.itis.service.UserService;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        UserService userService = ServiceFactory.getInstance().getUserService();


        boolean isRegistered = userService.isRegistered("Oleg");
        System.out.println(isRegistered);


        /** User newbie = new User.Builder()
                .setName("Tatyana")
                .setAge(23)
                .setCity("Moscow")
                .setId(4444)
                .build();

        userService.addUser(newbie);
         */

        Auto newCar = new Auto.Builder()
                .setId(111)
                .setMileage(0)
                .setModel("GLA")
                .setOwnerId(4444)
                .build();

        userService.addAuto(newCar);













    }

}
