package ru.bellintegrator.practice.api.office.service;

import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.model.Office;
import ru.bellintegrator.practice.api.office.view.ListView;

import java.util.List;

public interface OfficeService {

    Office get(int id);

    List<ListView> getList(OfficeList param);

    List<Office> save(OfficeList param);

    List<Office> update(OfficeList param);

}
