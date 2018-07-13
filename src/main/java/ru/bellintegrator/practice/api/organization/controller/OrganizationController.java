package ru.bellintegrator.practice.api.organization.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.api.organization.view.OrganizationView;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {


    @Autowired
    public OrganizationController() {

    }

    /**
     * Полоучить полный список компаний, позможен фильтр
     *
     * @param param
     * @return {@link List}<{@link OrganizationView}> список компаний.
     */
    @ApiOperation(value = "getOrganizations", nickname = "getOrganizations", httpMethod = "POST")
    @PostMapping("/list")
    public List<OrganizationView> getOrganizations(@RequestBody OrganizationView param) {
        return Collections.emptyList();
    }


    /**
     * Получить подробную информацию о компании.
     *
     * @param id id компании.
     * @return {@link OrganizationView} С полной информацией о компании.
     */
    @ApiOperation(value = "getOrganization", nickname = "getOrganization", httpMethod = "GET")
    @GetMapping("/{id}")
    public OrganizationView getOrganization(@PathVariable long id) {
        return new OrganizationView();
    }


    /**
     * Обновить запись компании.
     *
     * @param updateInfo {@link OrganizationView} Новая инормация о компании.
     * @return Статус выполнения.
     */
    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @GetMapping("/update")
    public String update(@RequestBody OrganizationView updateInfo) {
        return "{" +
                "“result”:”SuccessView”" +
                "}";
    }


    /**
     * Сохранение переданно инормации.
     * @param info переданная информация
     * @return Статус выполнения
     */
    @ApiOperation(value = "save", nickname = "save", httpMethod = "POST")
    @GetMapping("/save")
    public String save(@RequestBody OrganizationView info) {
        return "{" +
                "“result”:”SuccessView”" +
                "}";
    }

}
