package ru.bellintegrator.practice.api.organization.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.api.organization.datain.OrganizationList;
import ru.bellintegrator.practice.api.organization.view.OrganizationListView;
import ru.bellintegrator.practice.api.organization.view.OrganizationView;
import ru.bellintegrator.practice.api.publicview.StaticView;
import ru.bellintegrator.practice.api.publicview.SuccessView;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(OrganizationView.class);

    @Autowired
    public OrganizationController() {

    }

    /**
     * Полоучить полный список компаний, позможен фильтр
     *
     * @param param
     * @return {@link List}<{@link OrganizationList}> список компаний.
     */
    @ApiOperation(value = "getOrganizations", nickname = "getOrganizations", httpMethod = "POST")
    @PostMapping("/list")
    public List<OrganizationListView> getOrganizations(@RequestBody OrganizationList param) {
        LOG.info(param.toString());
        return Arrays.asList(
                new OrganizationListView(1, param.getName(), param.isActive()),
                new OrganizationListView(2, param.getInn(), true)
        );

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
    @PostMapping("/update")
    public String update(@RequestBody OrganizationView updateInfo) {
        return "{" +
                "“result”:”SuccessView”" +
                "}";
    }


    /**
     * Сохранение переданно инормации.
     *
     * @param info переданная информация
     * @return Статус выполнения
     */
    @ApiOperation(value = "save", nickname = "save", httpMethod = "POST")
    @PostMapping("/save")
    public StaticView save(@RequestBody OrganizationView info) {
        return new SuccessView();
    }

}
