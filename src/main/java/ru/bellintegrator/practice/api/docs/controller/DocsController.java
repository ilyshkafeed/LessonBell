package ru.bellintegrator.practice.api.docs.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.api.docs.view.DocsView;
import ru.bellintegrator.practice.api.office.view.OfficeView;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/docs", produces = APPLICATION_JSON_VALUE)
public class DocsController {


    @Autowired
    public DocsController() {

    }

    /**
     * Виды документов
     *
     * @return {@link List}<{@link DocsView}> список компаний.
     */
    @ApiOperation(value = "getDocs", nickname = "getDocs", httpMethod = "POST")
    @PostMapping()
    public List<DocsView> getOffices() {
        return Collections.emptyList();
    }

}
