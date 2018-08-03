package ru.bellintegrator.practice.api.organization.findings;

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

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class OrganizationUpdateTest extends ValidateTest {
    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // ========================================= name
    @Test
    public void validateName__nutNull(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,null,"123","1234567890","123456789","street","+71231231212",true);
        assertFalse(validate(org,"name", NotNull.class));
    }
    @Test
    public void validateName__regex(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"☺☻♥♦♣♠•◘○","123","1234567890","123456789","street","+71231231212",true);
        assertFalse(validate(org,"name", Pattern.class));
    }
    @Test
    public void validateName__min(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"1","123","1234567890","123456789","street","+71231231212",true);
        assertFalse(validate(org,"name", Size.class));
    }

    // ========================================= full name
    @Test
    public void validateFullName__notNull(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name",null,"1234567890","123456789","street","+71231231212",true);
        assertFalse(validate(org,"fullName", NotNull.class));
    }
    @Test
    public void validateFullName__regex(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","☺☻♥♦♣♠•◘○","1234567890","123456789","street","+71231231212",true);
        assertFalse(validate(org,"fullName", Pattern.class));
    }
    @Test
    public void validateFullName__min(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","1","1234567890","123456789","street","+71231231212",true);
        assertFalse(validate(org,"fullName", Size.class));
    }

    // ========================================= inn
    @Test
    public void validateInn__notNull(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name",null,"123456789","street","+71231231212",true);
        assertFalse(validate(org,"inn", NotNull.class));
    }
    @Test
    public void validateInn__sizeMin(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","123456789","123456789","street","+71231231212",true);
        assertFalse(validate(org,"inn", Size.class));
    }
    @Test
    public void validateInn__sizeMax(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","12345678900","123456789","street","+71231231212",true);
        assertFalse(validate(org,"inn", Size.class));
    }

    // ========================================= kpp
    @Test
    public void validateKpp__notNull(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890",null,"street","+71231231212",true);
        assertFalse(validate(org,"kpp", NotNull.class));
    }
    @Test
    public void validateKpp__sizeMin(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890","12345678","street","+71231231212",true);
        assertFalse(validate(org,"kpp", Size.class));

    }
    @Test
    public void validateKpp__sizeMax(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890","1234567890","street","+71231231212",true);
              assertFalse(validate(org,"kpp", Size.class));

    }

    // ========================================= address
    @Test
    public void validateAddress__notNull(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890","123456789",null,"+71231231212",true);
        assertFalse(validate(org,"address", NotNull.class));

    }

    // ========================================= phone
    @Test
    public void validatePhone__sizeMax(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890","123456789",null,"+712312312122",true);
        assertFalse(validate(org,"phone", Phone.class));
    }
    @Test
    public void validatePhone__sizeMin(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890","123456789",null,"+795356815",true);
        assertFalse(validate(org,"phone", Phone.class));
    }


    @Test
    public void validateObj__Ok(){
        OrganizationUpdate org = Creator.newOrganizationUpdate(1,"name","full name","1234567890","123456789","street","+71231231212",true);
        assertTrue(validate(org));
    }

}