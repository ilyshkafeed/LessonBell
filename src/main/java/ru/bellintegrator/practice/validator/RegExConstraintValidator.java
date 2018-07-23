package ru.bellintegrator.practice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class RegExConstraintValidator implements ConstraintValidator<RegEx, String> {

    RegEx regEx;

    @Override
    public void initialize(RegEx regEx) {
        this.regEx = regEx;
    }

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
        if (phoneField == null) {
            return false;
        }
        return phoneField.matches(regEx.value());
    }

}
