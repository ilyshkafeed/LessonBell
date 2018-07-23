package ru.bellintegrator.practice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {


    @Override
    public void initialize(Phone regEx) {
    }

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
        return phoneField == null || phoneField.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
    }

}
