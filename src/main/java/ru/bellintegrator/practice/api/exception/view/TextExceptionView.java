package ru.bellintegrator.practice.api.exception.view;

import ru.bellintegrator.practice.api.exception.RequiredFieldException;

import java.util.List;

public class TextExceptionView implements ExceptionView {

    private String error;

    public TextExceptionView(String str) {
        this.error = str;
    }

    public String getError() {
        return error;
    }


}
