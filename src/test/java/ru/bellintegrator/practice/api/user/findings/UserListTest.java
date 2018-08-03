package ru.bellintegrator.practice.api.user.findings;

import Utilites.Creator;
import Utilites.ValidateTest;
import org.junit.Before;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserListTest extends ValidateTest {
    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validateObj_ok() {
        UserList userList = Creator.newUserList(
                1,
                "Мослов",
                "Илья",
                "Петрович",
                "Админ",
                21,
                22
        );
        assertTrue(validate(userList));
    }

    @Test
    public void validateOfficeId_notNull() {
        UserList userList = Creator.newUserList(
                null,
                "Мослов",
                "Илья",
                "Петрович",
                "Админ",
                21,
                22
        );
        assertFalse(validate(userList, "officeId", NotNull.class));
    }


}