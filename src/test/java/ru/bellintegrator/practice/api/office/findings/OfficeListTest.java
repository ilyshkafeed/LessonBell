package ru.bellintegrator.practice.api.office.findings;

import Utilites.Creator;
import Utilites.ValidateTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.bellintegrator.practice.api.organization.findings.OrganizationList;
import ru.bellintegrator.practice.api.organization.findings.OrganizationSave;
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

public class OfficeListTest extends ValidateTest {

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validateOrgId_nutNull() {
        OfficeList officeList = Creator.newOfficeList(null,"name","+7 123 123-12-12",true);
        assertFalse(validate(officeList,"orgId", NotNull.class));
    }


    @Test
    public void validateName_min() {
        OfficeList officeList = Creator.newOfficeList(1,"","+7 123 123-12-12",true);
        assertFalse(validate(officeList,"name", Size.class));
    }
    @Test
    public void validateName_RegEx() {
        OfficeList officeList = Creator.newOfficeList(1,"Запрещено: ☺☻♥♦♣","+7 123 123-12-12",true);
        assertFalse(validate(officeList,"name", Pattern.class));
    }

    @Test
    public void validatePhone__sizeMax(){
        OfficeList officeList =  Creator.newOfficeList(1,"name","+712312312122",true);
        assertFalse(validate(officeList,"phone", Phone.class));
    }
    @Test
    public void validatePhone__sizeMin(){
        OfficeList officeList =  Creator.newOfficeList(1,"name","+7123123121",true);
        assertFalse(validate(officeList,"phone", Phone.class));
    }

    @Test
    public void validateObj__ok(){
        OfficeList officeList =  Creator.newOfficeList(1,"name","+71231231212",true);
        assertTrue(validate(officeList));
    }




}