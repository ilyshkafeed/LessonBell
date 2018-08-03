package ru.bellintegrator.practice.api.organization.findings;

import Utilites.Creator;
import Utilites.SetField;
import Utilites.ValidateTest;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

//TODO Нужен ли вообще?
public class OrganizationListTest extends ValidateTest {


    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }
    @Test
    public void validateName__notNull(){
        OrganizationList org = Creator.newOrganizationList(null,"1234567890",true);
        assertFalse(validate(org,"name", NotNull.class));
    }
    @Test
    public void validateName__regex(){
        OrganizationList org = Creator.newOrganizationList("Запрещеные символы: ☺☻♥♦♣♠","1234567890",true);
        assertFalse(validate(org,"name", Pattern.class));
    }
    @Test
    public void validateName__min(){
        OrganizationList org = Creator.newOrganizationList("","1234567890",true);
        assertFalse(validate(org,"name", Size.class));
    }

    @Test
    public void validateInn__size(){
        OrganizationList org = Creator.newOrganizationList("Имя","1234",true);
        assertFalse(validate(org,"inn", Size.class));
    }
    @Test
    public void validateObj__Ok(){
        OrganizationList org =Creator.newOrganizationList("Имя",null,null);
        assertTrue(validate(org));
    }

}