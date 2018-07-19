package ru.bellintegrator.practice.api.exception;

import java.util.List;

public class RequiredFieldException extends RuntimeException {


    private List<String> param;

    public RequiredFieldException() {
        super("Не заполнены обязательные поля");
    }

    public RequiredFieldException(List<String> fields) {
        this();
        this.param = fields;
    }

    public List<String> getFields() {
        return param;
    }

    @Override
    public String toString() {
        return getMessage() + ": " + String.join(", ", getFields());
    }

}
