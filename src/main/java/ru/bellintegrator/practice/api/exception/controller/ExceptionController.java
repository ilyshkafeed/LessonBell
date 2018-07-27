package ru.bellintegrator.practice.api.exception.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.api.exception.view.TextExceptionView;


@RestControllerAdvice
public class ExceptionController {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionController.class);


    @ExceptionHandler(Exception.class)
    protected ResponseEntity<TextExceptionView> exception(Exception e) {
        LOG.debug(e.getMessage(), e);
        return new ResponseEntity<>(new TextExceptionView(e.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
