package ru.bellintegrator.practice.api.exception.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.api.exception.RequiredFieldException;
import ru.bellintegrator.practice.api.exception.view.RequiredFieldExceptionView;


@RestControllerAdvice
public class ExceptionController {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(RequiredFieldException.class)
    protected ResponseEntity<RequiredFieldExceptionView> requiredFieldException(RequiredFieldException e) {
        LOG.debug("Входящий запрос: " + e);
        return new ResponseEntity<>(new RequiredFieldExceptionView(e), HttpStatus.BAD_REQUEST);
    }


}
