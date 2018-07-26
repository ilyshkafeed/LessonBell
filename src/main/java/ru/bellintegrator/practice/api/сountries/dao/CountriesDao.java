package ru.bellintegrator.practice.api.сountries.dao;

import ru.bellintegrator.practice.api.сountries.model.Countries;

public interface CountriesDao {

    Countries get(int id);

    Countries findByCode(int code);

    Countries findByName(String name);

}
