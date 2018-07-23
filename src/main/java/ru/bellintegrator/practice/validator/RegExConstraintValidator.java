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
    public boolean isValid(String regExField, ConstraintValidatorContext cxt) {
        return regExField == null || regExField.matches(regEx.value());
    }

}
