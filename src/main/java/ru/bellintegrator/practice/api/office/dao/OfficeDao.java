package ru.bellintegrator.practice.api.office.dao;

import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.model.Office;

import java.util.List;

public interface OfficeDao {


    /**
     * Получить обект по id
     *
     * @param id
     * @return
     */
    Office get(int id);

    /**
     * Получить неполный список
     *
     * @param data фильтры
     * @return
     */
    List<Office> getList(OfficeList data);


    void save(Office office);
    void delete(Office office);

    /**
     * Метод для отправки данных в бд.
     */
    void flush();
}
