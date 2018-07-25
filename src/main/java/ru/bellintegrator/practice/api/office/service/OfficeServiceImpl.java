package ru.bellintegrator.practice.api.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.api.office.dao.OfficeDao;
import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.model.Office;
import ru.bellintegrator.practice.api.office.view.ListView;
import ru.bellintegrator.practice.api.organization.dao.OrganizationDao;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao dao;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao) {
        this.dao = dao;
    }


    @Override
    public Office get(int id) {
        return null;
    }

    @Override
    public List<ListView> getList(OfficeList param) {
        return dao.getList(param).stream()
                .map(p -> new ListView(p.getId(), p.getName(), p.isActive()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Office> save(OfficeList param) {
        return null;
    }

    @Override
    public List<Office> update(OfficeList param) {
        return null;
    }
}
