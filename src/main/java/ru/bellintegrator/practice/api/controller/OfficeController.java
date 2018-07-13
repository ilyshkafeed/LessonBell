package ru.bellintegrator.practice.api.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.api.view.OfficeView;
import ru.bellintegrator.practice.api.view.OrganizationView;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {


    @Autowired
    public OfficeController() {

    }

    /**
     * Полоучить полный список офисов одной компании, позможен фильтр
     *
     * @param param
     * @return {@link List}<{@link OfficeView}> список компаний.
     */
    @ApiOperation(value = "getOrganizations", nickname = "getOrganizations", httpMethod = "POST")
    @PostMapping("/list/{orgId}")
    public List<OfficeView> getOrganizations(@PathVariable long orgId, @RequestBody OfficeView param) {
        return Collections.emptyList();
    }


    /**
     * Получить подробную информацию о офисе.
     *
     * @param id id компании.
     * @return {@link OrganizationView} С полной информацией о компании.
     */
    @ApiOperation(value = "getOrganization", nickname = "getOrganization", httpMethod = "GET")
    @GetMapping("/{id}")
    public OfficeView getOrganization(@PathVariable long id) {
        return new OfficeView();
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
                "“result”:”success”" +
                "}";
    }


    /**
     * Сохранение переданно инормации.
     *
     * @param info
     * @return
     */
    @ApiOperation(value = "save", nickname = "save", httpMethod = "POST")
    @GetMapping("/save")
    public String save(@RequestBody OrganizationView info) {
        return "{" +
                "“result”:”success”" +
                "}";
    }

}
