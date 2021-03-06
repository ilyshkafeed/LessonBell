package ru.bellintegrator.practice.api.office.findings;

import Utilites.Creator;
import Utilites.ValidateTest;
import org.junit.Before;
import org.junit.Test;
import ru.bellintegrator.practice.validator.Phone;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

import static org.junit.Assert.*;

public class OfficeUpdateTest extends ValidateTest {


    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // ============================================ id
    @Test
    public void validateId_nutNull() {
        OfficeUpdate officeUpdate = Creator.newOfficeUpdate(null,1, "name", "street", "+7 123 123-12-12", true);
        assertFalse(validate(officeUpdate, "id", NotNull.class));
    }

    // ============================================ name
    @Test
    public void validateName_notNull() {
        OfficeUpdate officeUpdate = Creator.newOfficeUpdate(1,1, null, "street", "+7 123 123-12-12", true);
        assertFalse(validate(officeUpdate, "name", NotNull.class));
    }

    @Test
    public void validateName_min() {
        OfficeUpdate officeUpdate = Creator.newOfficeUpdate(1,1, "", "street", "+7 123 123-12-12", true);
        assertFalse(validate(officeUpdate, "name", Size.class));
    }

    @Test
    public void validateName_RegEx() {
        OfficeUpdate officeUpdate = Creator.newOfficeUpdate(1,1, "Запрещено: ☺☻♥♦♣", "street", "+7 123 123-12-12", true);
        assertFalse(validate(officeUpdate, "name", Pattern.class));
    }

    // ============================================ addres
    @Test
    public void validateAddress_notNull() {
        OfficeUpdate officeUpdate = Creator.newOfficeUpdate(1,1, "name", null, "+7 123 123-12-12", true);
        assertFalse(validate(officeUpdate, "address", NotNull.class));
    }

    // ============================================ phone
    @Test
    public void validatePhone__sizeMax() {
        OfficeUpdate officeUpdate = Creator.newOfficeUpdate(1,1, "name", "street", "+712312312122", true);
        assertFalse(validate(officeUpdate, "phone", Phone.class));
    }

    @Test
    public void validatePhone__sizeMin() {
        OfficeUpdate officeUpdate = Creator.newOfficeUpdate(1,1, "name", "street", "+7123123121", true);
        assertFalse(validate(officeUpdate, "phone", Phone.class));
    }


    @Test
    public void validateObj__ok() {
        OfficeUpdate officeUpdate = Creator.newOfficeUpdate(1,1, "name", "street", "+71231231212", true);
        assertTrue(validate(officeUpdate));
    }


}