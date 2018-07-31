package ru.bellintegrator.practice.api.organization.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.api.exception.NoEntityFoundForQueryException;
import ru.bellintegrator.practice.api.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.api.organization.findings.OrganizationList;
import ru.bellintegrator.practice.api.organization.findings.OrganizationSave;
import ru.bellintegrator.practice.api.organization.findings.OrganizationUpdate;
import ru.bellintegrator.practice.api.organization.model.Organization;
import ru.bellintegrator.practice.api.organization.view.OrganizationListView;
import ru.bellintegrator.practice.api.organization.view.OrganizationView;
import ru.bellintegrator.practice.api.utilits.PhoneUtility;

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
        return dao.getShortList(in).stream().map(OrganizationListView::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationView get(int id) {
        return new OrganizationView(getOrganization(id));
    }

    @Override
    @Transactional
    public void delete(int id) {
        Organization org = getOrganization(id);
        dao.delete(org);
    }

    private Organization getOrganization(int id) {
        Organization org = dao.get(id);
        if (org == null) {
            throw new NoEntityFoundForQueryException("Organization");
        }
        return org;
    }


    @Override
    @Transactional
    public void update(OrganizationUpdate updateInfo) {
        Organization org = getOrganization(updateInfo.getId());
        org.setName(updateInfo.getName());
        org.setFullName(updateInfo.getFullName());
        org.setInn(updateInfo.getInn());
        org.setKpp(updateInfo.getKpp());
        org.setAddress(updateInfo.getAddress());
        org.setPhone(PhoneUtility.phoneToStandard(updateInfo.getPhone()));
        if (updateInfo.getPhone() != null) org.setAddress(updateInfo.getAddress());
        if (updateInfo.isActive() != null) org.setActive(updateInfo.isActive());

        dao.flush();
    }

    @Override
    @Transactional
    public void save(OrganizationSave info) {
        Organization org = new Organization();
        org.setName(info.getName());
        org.setFullName(info.getFullName());
        org.setInn(info.getInn());
        org.setKpp(info.getKpp());
        org.setAddress(info.getAddress());
        org.setPhone(PhoneUtility.phoneToStandard(info.getPhone()));
        if (info.getPhone() != null) org.setAddress(info.getAddress());
        if (info.isActive() != null) org.setActive(info.isActive());
        dao.save(org);
        dao.flush();
    }


}
