package ru.bellintegrator.practice.api.organization.service;

import ru.bellintegrator.practice.api.organization.findings.OrganizationList;
import ru.bellintegrator.practice.api.organization.findings.OrganizationSave;
import ru.bellintegrator.practice.api.organization.findings.OrganizationUpdate;
import ru.bellintegrator.practice.api.organization.view.OrganizationListView;
import ru.bellintegrator.practice.api.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationsService {


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

    void delete(int id);

    void update(OrganizationUpdate updateInfo);


    void save(OrganizationSave updateInfo);
}
