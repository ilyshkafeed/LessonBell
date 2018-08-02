package ru.bellintegrator.practice.api.organization.findings;

import Utilites.Creator;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class OrganizationUpdateTest {
    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // ========================================= name
    @Test
    public void validateName__null(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,null,"123","1234567890","123456789","street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void validateName__regex(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"☺☻♥♦♣♠•◘○","123","1234567890","123456789","street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void validateName__min(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"1","123","1234567890","123456789","street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }

    // ========================================= full name
    @Test
    public void validateFullName__null(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name",null,"1234567890","123456789","street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void validateFullName__regex(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","☺☻♥♦♣♠•◘○","1234567890","123456789","street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void validateFullName__min(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","1","1234567890","123456789","street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }

    // ========================================= inn
    @Test
    public void validateInn__null(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name",null,"123456789","street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void validateInn__sizeMin(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","123456789","123456789","street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void validateInn__sizeMax(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","12345678900","123456789","street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }

    // ========================================= kpp
    @Test
    public void validateKpp__null(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890",null,"street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void validateKpp__sizeMin(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890","12345678","street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void validateKpp__sizeMax(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890","1234567890","street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }

    // ========================================= address
    @Test
    public void validateAddress__null(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890","123456789",null,"+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }

    // ========================================= phone
    @Test
    public void validatePhone__sizeMax(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890","123456789",null,"+712312312122",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void validatePhone__sizeMin(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890","123456789",null,"+795356815",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertFalse(violations.isEmpty());
    }


    @Test
    public void validateObj__Ok(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890","123456789","street","+71231231212",true);
        Set<ConstraintViolation<OrganizationUpdate>> violations = validator.validate(org);
        assertTrue(violations.isEmpty());
    }


}