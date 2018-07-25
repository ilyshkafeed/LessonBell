package ru.bellintegrator.practice.api.office.dao;

import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.model.Office;
import ru.bellintegrator.practice.api.organization.findings.OrganizationList;
import ru.bellintegrator.practice.api.organization.model.Organization;

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


    void save(Office org);

    /**
     * Метод для отправки данных в бд.
     *
     */
    void flush();
}
