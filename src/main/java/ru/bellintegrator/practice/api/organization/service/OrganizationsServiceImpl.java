package ru.bellintegrator.practice.api.organization.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.api.exception.NoEentityFoundForQueryException;
import ru.bellintegrator.practice.api.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.api.organization.datain.OrganizationList;
import ru.bellintegrator.practice.api.organization.datain.OrganizationUpdate;
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
    @Transactional(readOnly = true)
    public List<OrganizationView> list() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrganizationListView> shortList(OrganizationList in) {
        if (!in.validate()) {
            throw in.getValidateException();
        }
        return dao.getShortList(in).stream().map(OrganizationListView::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationView get(int id) {
        return new OrganizationView(getOrganizationDao(id));
    }

    private Organization getOrganizationDao(int id) {
        Organization org = dao.get(id);
        if (org == null) {
            throw new NoEentityFoundForQueryException();
        }
        return org;
    }


    @Override
    @Transactional
    public void update(OrganizationUpdate updateInfo) {

        if (!updateInfo.validate()) {
            throw updateInfo.getValidateException();
        }
        System.out.println(updateInfo);
        Organization org = getOrganizationDao(updateInfo.getId());
        System.out.println(org);
        org.setName(updateInfo.getName());
        org.setFullName(updateInfo.getFullName());
        org.setInn(updateInfo.getInn());
        org.setKpp(updateInfo.getKpp());
        org.setAddress(updateInfo.getAddress());
        org.setPhone(updateInfo.getPhone());
        if (updateInfo.getPhone() != null) org.setAddress(updateInfo.getAddress());
        if (updateInfo.isActive() != null) org.setActive(updateInfo.isActive());
        System.out.println(org);
        dao.save();
    }


}
