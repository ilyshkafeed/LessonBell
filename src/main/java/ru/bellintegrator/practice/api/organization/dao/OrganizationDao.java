package ru.bellintegrator.practice.api.organization.dao;

import ru.bellintegrator.practice.api.organization.findings.OrganizationList;
import ru.bellintegrator.practice.api.organization.model.Organization;

import java.util.List;

public interface OrganizationDao {

    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<Organization> all();


    /**
     * Получить неполный список
     *
     * @param data фильтры
     * @return
     */
    List<Organization> getShortList(OrganizationList data);

    /**
     * Получить обект по id
     *
     * @param id
     * @return
     */
    Organization get(int id);

    /**
     * Метод для отправки данных в бд.
     */
    void flush();

    void save(Organization org);
    void delete(Organization org);

}
