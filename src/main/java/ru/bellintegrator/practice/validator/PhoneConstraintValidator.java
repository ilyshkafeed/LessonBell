package ru.bellintegrator.practice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {


    @Override
    public void initialize(Phone regEx) {
    }

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
        if (phoneField == null) return true;
        String numberOnly = phoneField.replaceAll("[^0-9]+", "");
        return (numberOnly.length() == 11)
                && phoneField.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
    }

}
