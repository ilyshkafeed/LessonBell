package ru.bellintegrator.practice.api.office.findings;

import Utilites.Creator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.bellintegrator.practice.api.organization.findings.OrganizationList;
import ru.bellintegrator.practice.api.organization.findings.OrganizationSave;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OfficeListTest {

    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validateOrgId_nutNull() {
        OfficeList officeList = Creator.newOfficeList(null,"name","+7 123 123-12-12",true);
        assertFalse(validate(officeList,"orgId"));
    }


    @Test
    public void validateName_min() {
        OfficeList officeList = Creator.newOfficeList(1,"","+7 123 123-12-12",true);
        assertFalse(validate(officeList,"name"));
    }
    @Test
    public void validateName_RegEx() {
        OfficeList officeList = Creator.newOfficeList(1,"Запрещено: ☺☻♥♦♣","+7 123 123-12-12",true);
        assertFalse(validate(officeList,"name"));
    }

    @Test
    public void validatePhone__sizeMax(){
        OfficeList officeList =  Creator.newOfficeList(1,"name","+712312312122",true);
        assertFalse(validate(officeList,"phone"));
    }
    @Test
    public void validatePhone__sizeMin(){
        OfficeList officeList =  Creator.newOfficeList(1,"name","+7123123121",true);
        assertFalse(validate(officeList,"phone"));
    }

    @Test
    public void validateObj__ok(){
        OfficeList officeList =  Creator.newOfficeList(1,"name","+71231231212",true);
        assertTrue(validate(officeList));
    }



    private boolean validate(Object office, String field) {
        Set<ConstraintViolation<Object>> violations = validator.validate(office);
        return violations.stream().filter(item -> item.getPropertyPath().toString().equals(field)).count() == 0;
    }
    private boolean validate(Object office) {
        Set<ConstraintViolation<Object>> violations = validator.validate(office);
        return violations.isEmpty();
    }

}