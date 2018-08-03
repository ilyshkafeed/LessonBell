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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OfficeSaveTest extends ValidateTest {


    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // ============================================ orgId
    @Test
    public void validateOrgId_nutNull() {
        OfficeSave officeSave = Creator.newOfficeSave(null, "name", "street", "+7 123 123-12-12", true);
        assertFalse(validate(officeSave, "orgId", NotNull.class));
    }

    // ============================================ name
    @Test
    public void validateName_notNull() {
        OfficeSave officeSave = Creator.newOfficeSave(1, null, "street", "+7 123 123-12-12", true);
        assertFalse(validate(officeSave, "name", NotNull.class));
    }

    @Test
    public void validateName_min() {
        OfficeSave officeSave = Creator.newOfficeSave(1, "", "street", "+7 123 123-12-12", true);
        assertFalse(validate(officeSave, "name", Size.class));
    }

    @Test
    public void validateName_RegEx() {
        OfficeSave officeSave = Creator.newOfficeSave(1, "Запрещено: ☺☻♥♦♣", "street", "+7 123 123-12-12", true);
        assertFalse(validate(officeSave, "name", Pattern.class));
    }

    // ============================================ addres
    @Test
    public void validateAddress_notNull() {
        OfficeSave officeSave = Creator.newOfficeSave(1, "name", null, "+7 123 123-12-12", true);
        assertFalse(validate(officeSave, "address", NotNull.class));
    }

    // ============================================ phone
    @Test
    public void validatePhone__sizeMax() {
        OfficeSave officeSave = Creator.newOfficeSave(1, "name", "street", "+712312312122", true);
        assertFalse(validate(officeSave, "phone", Phone.class));
    }

    @Test
    public void validatePhone__sizeMin() {
        OfficeSave officeSave = Creator.newOfficeSave(1, "name", "street", "+7123123121", true);
        assertFalse(validate(officeSave, "phone", Phone.class));
    }


    @Test
    public void validateObj__ok() {
        OfficeSave officeSave = Creator.newOfficeSave(1, "name", "street", "+71231231212", true);
        assertTrue(validate(officeSave));
    }




}