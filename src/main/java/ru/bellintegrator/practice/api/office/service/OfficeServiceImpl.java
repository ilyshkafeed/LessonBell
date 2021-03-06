package ru.bellintegrator.practice.api.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.api.exception.NoEntityFoundForQueryException;
import ru.bellintegrator.practice.api.office.dao.OfficeDao;
import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.findings.OfficeSave;
import ru.bellintegrator.practice.api.office.findings.OfficeUpdate;
import ru.bellintegrator.practice.api.office.model.Office;
import ru.bellintegrator.practice.api.office.view.ListView;
import ru.bellintegrator.practice.api.office.view.OfficeView;
import ru.bellintegrator.practice.api.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.api.organization.model.Organization;
import ru.bellintegrator.practice.api.utilits.PhoneUtility;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao dao;
    private final OrganizationDao ogrDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao, OrganizationDao orgDao) {
        this.ogrDao = orgDao;
        this.dao = dao;
    }


    @Override
    @Transactional(readOnly = true)
    public OfficeView get(int id) {
        Office o = getOffice(id);
        return new OfficeView(o);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Office office = getOffice(id);
        dao.delete(office);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListView> getList(OfficeList param) {
        getOrganization(param.getOrgId());
        return dao.getList(param).stream()
                .map(p -> new ListView(p.getId(), p.getName(), p.isActive()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(OfficeSave param) {
        Organization org = getOrganization(param.getOrgId());
        Office o = new Office();
        o.setName(param.getName());
        o.setAddress(param.getAddress());
        org.addOffice(o);
        if (param.getPhone() != null) {
            o.setPhone(PhoneUtility.phoneToStandard(param.getPhone()));
        }
        if (param.isActive() != null) {
            o.setActive(param.isActive());
        }
        dao.save(o);
        dao.flush();
    }

    @Override
    @Transactional
    public void update(OfficeUpdate param) {
        Office o = getOffice(param.getId());
        o.setName(param.getName());
        o.setAddress(param.getAddress());
        if (param.getPhone() != null) {
            o.setPhone(PhoneUtility.phoneToStandard(param.getPhone()));
        }
        if (param.isActive() != null) {
            o.setActive(param.isActive());
        }
        if (param.getOrgId() != null) {
            o.getOrganization().getOffices().remove(o);
            Organization org = getOrganization(param.getOrgId());
            org.addOffice(o);
        }
        dao.flush();
    }


    private Organization getOrganization(int id) {
        Organization org = ogrDao.get(id);
        if (org == null) {
            throw new NoEntityFoundForQueryException("Organization");
        }
        return org;
    }

    private Office getOffice(int id) {
        Office org = dao.get(id);
        if (org == null) {
            throw new NoEntityFoundForQueryException("Office");
        }
        return org;
    }

}
