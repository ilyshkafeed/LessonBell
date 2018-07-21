package ru.bellintegrator.practice.api.exception;

import java.util.List;

public class NoEentityFoundForQueryException extends RuntimeException {


    public NoEentityFoundForQueryException() {
        super("Не найдена сущность для запроса");
    }


}
