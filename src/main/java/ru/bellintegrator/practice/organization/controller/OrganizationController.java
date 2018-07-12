package ru.bellintegrator.practice.organization.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.person.view.PersonView;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {


    @Autowired
    public OrganizationController() {

    }

//    private final OrganizationService organizationService;
//
//    @Autowired
//    public OrganizationController(OrganizationService organizationService) {
//        this.organizationService = organizationService;
//    }


//
//    @ApiOperation(value = "addPerson", nickname = "addPerson", httpMethod = "POST")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success", response = String.class),
//            @ApiResponse(code = 404, message = "Not Found"),
//            @ApiResponse(code = 500, message = "Failure")})
//    @PostMapping("/person")
//    public void person(@RequestBody OrganizationSmallView person) {
//        personService.add(person);
//    }

//    @ApiOperation(value = "addPerson", nickname = "addPerson", httpMethod = "POST")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success", response = String.class),
//            @ApiResponse(code = 404, message = "Not Found"),
//            @ApiResponse(code = 500, message = "Failure")})
//    @PostMapping("/organization")
//    public void person(@RequestBody PersonView person) {
//        personService.add(person);
//    }
//
    @ApiOperation(value = "getOrganization", nickname = "getOrganization", httpMethod = "post")
    @PostMapping("/list")
    public List<OrganizationView> persons(@RequestBody OrganizationView name) {
        return Collections.emptyList();
    }


}
