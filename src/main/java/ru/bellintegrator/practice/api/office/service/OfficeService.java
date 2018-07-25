package ru.bellintegrator.practice.api.office.service;

import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.findings.OfficeSave;
import ru.bellintegrator.practice.api.office.findings.OfficeUpdate;
import ru.bellintegrator.practice.api.office.view.ListView;
import ru.bellintegrator.practice.api.office.view.OfficeView;

import java.util.List;

public interface OfficeService {

    OfficeView get(int id);

    List<ListView> getList(OfficeList param);

    void save(OfficeSave param);

    void update(OfficeUpdate param);

}
