package ru.bellintegrator.practice.api.office.findings;

import Utilites.Creator;
import Utilites.ValidateTest;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
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
        assertFalse(validate(officeSave, "orgId"));
    }

    // ============================================ name
    @Test
    public void validateName_notNull() {
        OfficeSave officeSave = Creator.newOfficeSave(1, null, "street", "+7 123 123-12-12", true);
        assertFalse(validate(officeSave, "name"));
    }

    @Test
    public void validateName_min() {
        OfficeSave officeSave = Creator.newOfficeSave(1, "", "street", "+7 123 123-12-12", true);
        assertFalse(validate(officeSave, "name"));
    }

    @Test
    public void validateName_RegEx() {
        OfficeSave officeSave = Creator.newOfficeSave(1, "Запрещено: ☺☻♥♦♣", "street", "+7 123 123-12-12", true);
        assertFalse(validate(officeSave, "name"));
    }

    // ============================================ addres
    @Test
    public void validateAddress_notNull() {
        OfficeSave officeSave = Creator.newOfficeSave(1, "name", null, "+7 123 123-12-12", true);
        assertFalse(validate(officeSave, "address"));
    }

    // ============================================ phone
    @Test
    public void validatePhone__sizeMax() {
        OfficeSave officeSave = Creator.newOfficeSave(1, "name", "street", "+712312312122", true);
        assertFalse(validate(officeSave, "phone"));
    }

    @Test
    public void validatePhone__sizeMin() {
        OfficeSave officeSave = Creator.newOfficeSave(1, "name", "street", "+7123123121", true);
        assertFalse(validate(officeSave, "phone"));
    }


    @Test
    public void validateObj__ok() {
        OfficeSave officeSave = Creator.newOfficeSave(1, "name", "street", "+71231231212", true);
        assertTrue(validate(officeSave));
    }




}