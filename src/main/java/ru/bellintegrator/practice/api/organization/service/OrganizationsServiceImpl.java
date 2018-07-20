package ru.bellintegrator.practice.api.organization.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.api.exception.NoEentityFoundForQuery;
import ru.bellintegrator.practice.api.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.api.organization.datain.OrganizationList;
import ru.bellintegrator.practice.api.organization.model.Organization;
import ru.bellintegrator.practice.api.organization.view.OrganizationListView;
import ru.bellintegrator.practice.api.organization.view.OrganizationView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationsServiceImpl implements OrganizationsService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final OrganizationDao dao;

    @Autowired
    public OrganizationsServiceImpl(OrganizationDao dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(OrganizationView organization) {


    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrganizationView> list() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrganizationListView> shortList(OrganizationList in) {
        if (!in.validate()) {
            throw in.getValidateException();
        }
        return dao.getShortList(in).stream().map(OrganizationListView::new).collect(Collectors.toList());
    }

    @Override
    public OrganizationView get(int id) {
        Organization org = dao.get(id);
        if (org == null) {
            throw new NoEentityFoundForQuery();
        }
        return new OrganizationView(org);
    }


}
