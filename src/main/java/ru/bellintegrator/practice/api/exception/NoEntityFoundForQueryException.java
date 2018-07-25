package ru.bellintegrator.practice.api.exception;

import java.util.List;

public class NoEntityFoundForQueryException extends RuntimeException {


    public NoEntityFoundForQueryException(String nameEntity) {
        super("Не найдена сущность '" + nameEntity + "'");
    }


}
