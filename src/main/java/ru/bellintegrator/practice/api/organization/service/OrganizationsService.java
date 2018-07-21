package ru.bellintegrator.practice.api.organization.service;

import ru.bellintegrator.practice.api.organization.datain.OrganizationList;
import ru.bellintegrator.practice.api.organization.datain.OrganizationUpdate;
import ru.bellintegrator.practice.api.organization.view.OrganizationListView;
import ru.bellintegrator.practice.api.organization.view.OrganizationView;

import java.util.List;

public interface  OrganizationsService {
    /**
     * Добавить новую организацию в БД
     *
     * @param organization
     */
    void add(OrganizationView organization);



    /**
     * Получить список организаций
     *
     * @return {@Person}
     */
    List<OrganizationView> list();

    /**
     * Получить краткий список организаций
     *
     * @return {@Person}
     */
    List<OrganizationListView> shortList(OrganizationList in);


    OrganizationView get(int id);

    void update(OrganizationUpdate updateInfo);
}
