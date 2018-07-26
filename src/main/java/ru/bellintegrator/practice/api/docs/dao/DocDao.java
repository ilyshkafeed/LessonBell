package ru.bellintegrator.practice.api.docs.dao;

import ru.bellintegrator.practice.api.docs.model.Doc;

public interface DocDao {

    Doc get(int id);

    Doc findByCode(int code);

    Doc findByName(String name);

}
