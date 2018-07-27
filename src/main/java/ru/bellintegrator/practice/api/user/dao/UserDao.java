package ru.bellintegrator.practice.api.user.dao;

import ru.bellintegrator.practice.api.user.findings.UserList;
import ru.bellintegrator.practice.api.user.model.User;

import java.util.List;

public interface UserDao {


    /**
     * Получить обект по id
     *
     * @param id
     * @return
     */
    User get(int id);

    /**
     * Получить неполный список
     *
     * @param data фильтры
     * @return
     */
    List<User> getList(UserList data);


    void save(User user);
    void delete(User user);

    /**
     * Метод для отправки данных в бд.
     */
    void flush();
}
