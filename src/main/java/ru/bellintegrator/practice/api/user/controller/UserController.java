package ru.bellintegrator.practice.api.user.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.api.user.view.UserView;


import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {


    @Autowired
    public UserController() {

    }

    /**
     * Получить список всех пользователей, возможны фиьтры.
     *
     * @param param
     * @return {@link List}<{@link UserView}> список пользователей.
     */
    @ApiOperation(value = "getUsers", nickname = "getUsers", httpMethod = "POST")
    @PostMapping("/list")
    public List<UserView> getUsers(@RequestBody UserView param) {
        return Collections.emptyList();
    }


    /**
     * Получить подробную информацию о пользователе.
     *
     * @param id id компании.
     * @return {@link UserView} С полной информацией о пользователе.
     */
    @ApiOperation(value = "getUser", nickname = "getUser", httpMethod = "GET")
    @GetMapping("/{id}")
    public UserView getUser(@PathVariable long id) {
        return new UserView();
    }


    /**
     * Обновить запись пользователя.
     *
     * @param updateInfo {@link UserView} Новая инормация о пользоватьеле.
     * @return Статус выполнения.
     */
    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @GetMapping("/update")
    public String update(@RequestBody UserView updateInfo) {
        return "{" +
                "“result”:”ResultView”" +
                "}";
    }


    /**
     * Сохранение переданной инормации.
     *
     * @param info переданная информация
     * @return статус
     */
    @ApiOperation(value = "flush", nickname = "flush", httpMethod = "POST")
    @GetMapping("/save")
    public String save(@RequestBody UserView info) {
        return "{" +
                "“result”:”ResultView”" +
                "}";
    }

}
