package ru.bellintegrator.practice.api.сountries.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.api.сountries.view.CountriesView;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/docs", produces = APPLICATION_JSON_VALUE)
public class CountriesController {


    @Autowired
    public CountriesController() {

    }

    /**
     * Место проживания
     *
     * @return {@link List}<{@link CountriesView}> список компаний.
     */
    @ApiOperation(value = "getOffices", nickname = "getOffices", httpMethod = "POST")
    @PostMapping("/")
    public List<CountriesView> getOffices() {
        return Collections.emptyList();
    }

}
