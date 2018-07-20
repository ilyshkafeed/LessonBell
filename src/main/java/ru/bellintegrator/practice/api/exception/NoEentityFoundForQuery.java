package ru.bellintegrator.practice.api.exception;

import java.util.List;

public class NoEentityFoundForQuery extends RuntimeException {


    public NoEentityFoundForQuery() {
        super("Не найдена сущность для запроса");
    }


}
