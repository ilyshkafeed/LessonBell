package ru.bellintegrator.practice.api.exception.view;

import ru.bellintegrator.practice.api.exception.RequiredFieldException;
import ru.bellintegrator.practice.api.publicview.StaticView;

import java.util.List;

public class RequiredFieldExceptionView implements StaticView {

    private String error;
    private List<String> fields;


    public RequiredFieldExceptionView() {
    }

    public RequiredFieldExceptionView(String error) {
        this.error = error;
    }

    public RequiredFieldExceptionView(String error, List<String> fields) {
        this(error);
        this.fields = fields;
    }

    public RequiredFieldExceptionView(RequiredFieldException exception) {
        this(exception.getMessage(), exception.getFields());
    }


    public String getError() {
        return error;
    }

    public List<String> getFields() {
        return fields;
    }


}
