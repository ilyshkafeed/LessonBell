package ru.bellintegrator.practice.api.office.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.api.ValidateUtilits;
import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.view.OfficeView;
import ru.bellintegrator.practice.api.view.ResultView;
import ru.bellintegrator.practice.api.view.StaticView;

import javax.validation.Valid;
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
    @ApiOperation(value = "getOffices", nickname = "getOffices", httpMethod = "POST")
    @PostMapping("/list")
    public List<OfficeView> getOffices(@Valid @RequestBody OfficeList param, BindingResult bindingResult) {
        ValidateUtilits.validateBindingResult(bindingResult);
        return Collections.emptyList();
    }


    /**
     * Получить подробную информацию о офисе.
     *
     * @param id id компании.
     * @return {@link OfficeView} С полной информацией о компании.
     */
    @ApiOperation(value = "getOffice", nickname = "getOffice", httpMethod = "GET")
    @GetMapping("/{id}")
    public OfficeView getOffice(@PathVariable long id) {
        return new OfficeView();
    }


    /**
     * Обновить запись офиса.
     *
     * @param updateInfo {@link OfficeView} Новая инормация о компании.
     * @return Статус выполнения.
     */
    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @GetMapping("/update")
    public StaticView update(@RequestBody OfficeView updateInfo) {
        return ResultView.SUCCESS;
    }


    /**
     * Сохранение переданной инормации.
     *
     * @param info переданная информация
     * @return статус
     */
    @ApiOperation(value = "flush", nickname = "flush", httpMethod = "POST")
    @GetMapping("/save")
    public StaticView save(@RequestBody OfficeView info) {
        return ResultView.SUCCESS;
    }

}
