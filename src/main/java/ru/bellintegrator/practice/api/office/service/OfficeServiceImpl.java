package ru.bellintegrator.practice.api.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.api.office.dao.OfficeDao;
import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.model.Office;
import ru.bellintegrator.practice.api.office.view.ListView;
import ru.bellintegrator.practice.api.office.view.OfficeView;

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
    @Transactional(readOnly = true)
    public OfficeView get(int id) {
        Office o = dao.get(id);
        return new OfficeView(o);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListView> getList(OfficeList param) {
        return dao.getList(param).stream()
                .map(p -> new ListView(p.getId(), p.getName(), p.isActive()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Office> save(OfficeList param) {
        return null;
    }

    @Override
    @Transactional
    public List<Office> update(OfficeList param) {
        return null;
    }
}
