package ru.bellintegrator.practice.api.organization.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.annotations.AutoWrapping;
import ru.bellintegrator.practice.api.exception.view.TextExceptionView;
import ru.bellintegrator.practice.api.organization.findings.OrganizationList;
import ru.bellintegrator.practice.api.organization.findings.OrganizationSave;
import ru.bellintegrator.practice.api.organization.findings.OrganizationUpdate;
import ru.bellintegrator.practice.api.organization.service.OrganizationsService;
import ru.bellintegrator.practice.api.organization.view.OrganizationListView;
import ru.bellintegrator.practice.api.organization.view.OrganizationView;
import ru.bellintegrator.practice.api.view.ResultView;
import ru.bellintegrator.practice.api.utilits.ValidateUtilits;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
@AutoWrapping
public class OrganizationController {

    private final OrganizationsService organizationsService;


    private static final Logger LOG = LoggerFactory.getLogger(OrganizationView.class);

    @Autowired
    public OrganizationController(OrganizationsService organizationsService) {
        this.organizationsService = organizationsService;
    }

    /**
     * Полоучить полный список компаний, позможен фильтр
     *
     * @param param
     * @return {@link List}<{@link OrganizationList}> список компаний.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @ApiOperation(value = "getOrganizations", nickname = "getOrganizations", httpMethod = "POST")
    @PostMapping("/list")
    public List<OrganizationListView> getOrganizations(@Valid @RequestBody OrganizationList param, BindingResult bindingResult) {
        ValidateUtilits.validateBindingResult(bindingResult);
        return (organizationsService.shortList(param));
    }


    /**
     * Получить подробную информацию о компании.
     *
     * @param id id компании.
     * @return {@link OrganizationView} С полной информацией о компании.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @ApiOperation(value = "getOrganization", nickname = "getOrganization", httpMethod = "GET")
    @GetMapping("/{id}")
    public OrganizationView getOrganization(@PathVariable int id) {
        return organizationsService.get(id);
    }


    /**
     * Удалить организацию.
     *
     * @param id id компании.
     * @return {@link ResultView}
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @ApiOperation(value = "delete", nickname = "delete", httpMethod = "GET")
    @GetMapping("/{id}/delete")
    public ResultView deleteOrganization(@PathVariable int id) {
        organizationsService.delete(id);
        return ResultView.SUCCESS;
    }


    /**
     * Обновить запись компании.
     *
     * @param updateInfo {@link OrganizationView} Новая инормация о компании.
     * @return Статус выполнения.
     */
    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @PostMapping("/update")
    public ResultView update(@Valid @RequestBody OrganizationUpdate updateInfo, BindingResult bindingResult) {
        ValidateUtilits.validateBindingResult(bindingResult);
        organizationsService.update(updateInfo);
        return ResultView.SUCCESS;
    }


    /**
     * Сохранение переданно инормации.
     *
     * @param info переданная информация
     * @return Статус выполнения
     */
    @ApiOperation(value = "flush", nickname = "flush", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @PostMapping("/save")
    public ResultView save(@RequestBody OrganizationSave info, BindingResult bindingResult) {
        ValidateUtilits.validateBindingResult(bindingResult);
        organizationsService.save(info);
        return ResultView.SUCCESS;
    }


}
