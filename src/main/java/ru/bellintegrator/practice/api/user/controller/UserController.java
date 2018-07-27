package ru.bellintegrator.practice.api.user.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.api.exception.view.TextExceptionView;
import ru.bellintegrator.practice.api.user.findings.UserList;
import ru.bellintegrator.practice.api.user.findings.UserSave;
import ru.bellintegrator.practice.api.user.findings.UserUpdate;
import ru.bellintegrator.practice.api.user.service.UserService;
import ru.bellintegrator.practice.api.user.view.ListView;
import ru.bellintegrator.practice.api.user.view.UserView;
import ru.bellintegrator.practice.api.view.ResultView;
import ru.bellintegrator.practice.utilits.ValidateUtilits;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Получить список всех пользователей, возможны фиьтры.
     *
     * @param param
     * @return {@link List}<{@link UserView}> список пользователей.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @ApiOperation(value = "getUsers", nickname = "getUsers", httpMethod = "POST")
    @PostMapping("/list")
    public List<ListView> getUsers(@Valid @RequestBody UserList param, BindingResult bindingResult) {
        ValidateUtilits.validateBindingResult(bindingResult);
        return userService.getList(param);
    }


    /**
     * Получить подробную информацию о пользователе.
     *
     * @param id id компании.
     * @return {@link UserView} С полной информацией о пользователе.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @ApiOperation(value = "getUser", nickname = "getUser", httpMethod = "GET")
    @GetMapping("/{id}")
    public UserView getUser(@PathVariable int id) {
        return userService.get(id);
    }


    /**
     * Обновить запись пользователя.
     *
     * @param updateInfo {@link UserView} Новая инормация о пользоватьеле.
     * @return Статус выполнения.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = TextExceptionView.class)
    })
    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @PostMapping("/update")
    public ResultView update(@Valid @RequestBody UserUpdate updateInfo, BindingResult bindingResult) {
        ValidateUtilits.validateBindingResult(bindingResult);
        userService.update(updateInfo);
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
    public ResultView save(@Valid @RequestBody UserSave info, BindingResult bindingResult) {
        ValidateUtilits.validateBindingResult(bindingResult);
        userService.save(info);
        return ResultView.SUCCESS;
    }

}
