package ru.bellintegrator.practice.api.exception;

public class NoEntityFoundForQueryException extends RuntimeException {

    public NoEntityFoundForQueryException(String nameEntity) {
        super("Не найдена сущность '" + nameEntity + "'");
    }

}
