package ru.bellintegrator.practice.api.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.api.view.ListView;
import ru.bellintegrator.practice.api.view.OrganizationView;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {


    @Autowired
    public OrganizationController() {

    }

    @ApiOperation(value = "getOrganization", nickname = "getOrganization", httpMethod = "post")
    @PostMapping("/list")
    public List<ListView> persons(@RequestBody ListView param) {
        return Collections.emptyList();
    }

    @ApiOperation(value = "getOrganization", nickname = "getOrganization", httpMethod = "get")
    @GetMapping("/{id}")
    public List<OrganizationView> persons(@RequestBody int id) {
        return Collections.emptyList();
    }



}
