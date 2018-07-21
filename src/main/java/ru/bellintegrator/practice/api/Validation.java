package ru.bellintegrator.practice.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public interface Validation {
    @JsonIgnore
    boolean validate();

    @JsonIgnore
    RuntimeException getValidateException();
}
