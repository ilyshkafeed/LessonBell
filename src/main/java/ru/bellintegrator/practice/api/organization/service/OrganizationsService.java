package ru.bellintegrator.practice.api.organization.service;

import ru.bellintegrator.practice.api.organization.view.OrganizationView;
import ru.bellintegrator.practice.api.organization.view.ListView;

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
    List<OrganizationView> organizations();

    /**
     * Получить краткий список организаций
     *
     * @return {@Person}
     */
    List<ListView> organizationsList();

}
