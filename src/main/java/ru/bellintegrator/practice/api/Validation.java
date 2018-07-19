package ru.bellintegrator.practice.api;

import java.util.List;

public interface Validation {
    boolean validate();

    RuntimeException getValidateException();
}
