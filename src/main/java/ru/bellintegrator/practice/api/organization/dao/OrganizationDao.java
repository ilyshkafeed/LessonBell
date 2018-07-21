package ru.bellintegrator.practice.api.organization.dao;

import ru.bellintegrator.practice.api.organization.datain.OrganizationList;
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

    void save();

}
