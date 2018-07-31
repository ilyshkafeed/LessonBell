package ru.bellintegrator.practice.api.office.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.api.exception.view.TextExceptionView;
import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.findings.OfficeSave;
import ru.bellintegrator.practice.api.office.findings.OfficeUpdate;
import ru.bellintegrator.practice.api.office.service.OfficeService;
import ru.bellintegrator.practice.api.office.view.ListView;
import ru.bellintegrator.practice.api.office.view.OfficeView;
import ru.bellintegrator.practice.api.view.ResultView;
import ru.bellintegrator.practice.api.utilits.ValidateUtilits;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService officeService;


    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Полоучить полный список офисов одной компании, позможен фильтр
     *
     * @param param
     * @return {@link List}<{@link ListView}> список компаний.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @ApiOperation(value = "getOffices", nickname = "getOffices", httpMethod = "POST")
    @PostMapping("/list")
    public List<ListView> getOffices(@Valid @RequestBody OfficeList param, BindingResult bindingResult) {
        ValidateUtilits.validateBindingResult(bindingResult);
        return officeService.getList(param);
    }


    /**
     * Получить подробную информацию о офисе.
     *
     * @param id id компании.
     * @return {@link OfficeView} С полной информацией о компании.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @ApiOperation(value = "getOffice", nickname = "getOffice", httpMethod = "GET")
    @GetMapping("/{id}")
    public OfficeView getOffice(@PathVariable int id) {
        return officeService.get(id);
    }

    /**
     * Удаление офиса
     *
     * @param id id компании.
     * @return {@link OfficeView} С полной информацией о компании.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @ApiOperation(value = "delete", nickname = "delete", httpMethod = "GET")
    @GetMapping("/{id}/delete")
    public ResultView deleteOffice(@PathVariable int id) {
        officeService.delete(id);
        return ResultView.SUCCESS;
    }


    /**
     * Обновить запись офиса.
     *
     * @param updateInfo {@link OfficeView} Новая инормация о компании.
     * @return Статус выполнения.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @PostMapping("/update")
    public ResultView update(@Valid @RequestBody OfficeUpdate updateInfo, BindingResult bindingResult) {
        ValidateUtilits.validateBindingResult(bindingResult);
        officeService.update(updateInfo);
        return ResultView.SUCCESS;
    }


    /**
     * Сохранение переданной инормации.
     *
     * @param info переданная информация
     * @return статус
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @ApiOperation(value = "flush", nickname = "flush", httpMethod = "POST")
    @PostMapping("/save")
    public ResultView save(@RequestBody OfficeSave info) {
        officeService.save(info);
        return ResultView.SUCCESS;
    }

}
