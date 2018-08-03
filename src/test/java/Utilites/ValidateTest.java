package Utilites;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class ValidateTest {
    protected static Validator validator;



    protected boolean validate(Object office, String field) {
        Set<ConstraintViolation<Object>> violations = validator.validate(office);
        return violations.stream().noneMatch(item -> item.getPropertyPath().toString().equals(field));
    }
    protected boolean validate(Object office) {
        Set<ConstraintViolation<Object>> violations = validator.validate(office);
        return violations.isEmpty();
    }
}
