package ru.itis.service;

import ru.itis.dao.AutoDao;
import ru.itis.dao.UsersDao;
import ru.itis.model.Auto;
import ru.itis.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UsersDao usersDao;
    private AutoDao autoDao;

    public UserServiceImpl(UsersDao usersDao, AutoDao autoDao) {
        this.usersDao = usersDao;
        this.autoDao = autoDao;
    }

    public boolean isRegistered(String name) {
        List<User> users = usersDao.findAll();

        for (User currentUser : users) {
            if (currentUser.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public void addUser(User user) {
        long lastInsertID = usersDao.save(user);
        /**for (Auto auto : user.getAutos()) {
            autoDao.save(new Auto.Builder()
                    .setOwnerId((int)lastInsertID)
                    .setModel(auto.getModel())
                    .setMileage(auto.getMileage())
                    .build()
            );
        }  */
    }

    public void addAuto(Auto auto) {
        autoDao.save(auto);
    }

}
