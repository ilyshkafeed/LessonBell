package ru.bellintegrator.practice.api.organization.findings;

import Utilites.SetField;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


public class OrganizationListTest {


    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void validateName__null(){
        OrganizationList org = newOrganizationList(null,"1234567890",true);
        Set<ConstraintViolation<OrganizationList>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void validateName__regex(){
        OrganizationList org = newOrganizationList("Запрещеные символы: ☺☻♥♦♣♠","1234567890",true);
        Set<ConstraintViolation<OrganizationList>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void validateName__min(){
        OrganizationList org = newOrganizationList("","1234567890",true);
        Set<ConstraintViolation<OrganizationList>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validateInn__size(){
        OrganizationList org = newOrganizationList("Имя","1234",true);
        Set<ConstraintViolation<OrganizationList>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void validateObj__Ok(){
        OrganizationList org = newOrganizationList("Имя",null,null);
        Set<ConstraintViolation<OrganizationList>> violations = validator.validate(org);
        assertTrue(violations.isEmpty());
    }





    private OrganizationList newOrganizationList(String name, String inn, Boolean isActive) {
        OrganizationList organizationList = new OrganizationList();
        SetField.set(organizationList, "name", name);
        SetField.set(organizationList, "inn", inn);
        SetField.set(organizationList, "isActive", isActive);
        return organizationList;
    }

}