package ru.itis.service;

import ru.itis.model.Auto;
import ru.itis.model.User;

import java.util.List;

public interface UserService {
    /**
     * есть ли пользователь в системе
     * @param name
     * @return
     */
    boolean isRegistered(String name);

    /**
     * получить всех пользователей живущих в определенном городе
     * @param city
     * @return
     */
    //List<User> getAllUsersFromACity(String city);

    /**
     * получить все машины, пользователи которых живут в определенном город
     * @param city
     * @return
     */
    //List<Auto> getAllAutosFromACity(String city);

    /**
     * Добавить нового юзера (возможно, с машинами)
     * @param user
     */
    void addUser(User user);
    void addAuto(Auto auto);

    /**
     * Найти юезера по ID
     * @param id
     * @return
     */
    //User findUser(int id);

//    update user (with cars)
//    delete user (with cars)
}
