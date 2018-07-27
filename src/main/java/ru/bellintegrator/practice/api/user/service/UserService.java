package ru.bellintegrator.practice.api.user.service;


import ru.bellintegrator.practice.api.user.findings.UserList;
import ru.bellintegrator.practice.api.user.findings.UserSave;
import ru.bellintegrator.practice.api.user.findings.UserUpdate;
import ru.bellintegrator.practice.api.user.view.ListView;
import ru.bellintegrator.practice.api.user.view.UserView;

import java.util.List;

public interface UserService {

    UserView get(int id);

    void delete(int id);

    List<ListView> getList(UserList param);

    void save(UserSave param);

    void update(UserUpdate param);

}
