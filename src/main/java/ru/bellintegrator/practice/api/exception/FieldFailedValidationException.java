package ru.bellintegrator.practice.api.exception;

public class FieldFailedValidationException extends RuntimeException {


    public FieldFailedValidationException(String field) {
        super("Поле \"" + field + "\" не прошло проверку");
    }


}
