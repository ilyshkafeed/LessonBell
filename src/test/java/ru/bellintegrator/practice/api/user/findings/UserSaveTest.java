package ru.bellintegrator.practice.api.user.findings;

import Utilites.Creator;
import Utilites.ValidateTest;
import org.junit.Before;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserSaveTest extends ValidateTest {
    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validateObj_ok() {
        UserSave userSave = Creator.newUserSave(
                1,
                "Мослов",
                "Илья",
                "Петрович",
                "Админ",
                "+7 123 123-12-12",
                "12312333",
                "Паспорт",
                new Date(),
                (short) 21,
                true
        );
        assertTrue(validate(userSave));
    }

    @Test
    public void validateOfficeId_notNull() {
        UserSave userSave = Creator.newUserSave(
                null,
                "Мослов",
                "Илья",
                "Петрович",
                "Админ",
                "+7 123 123-12-12",
                "12312333",
                "Паспорт",
                new Date(),
                (short) 21,
                true
        );
        assertFalse(validate(userSave, "officeId", NotNull.class));
    }

    @Test
    public void validateFirstName_notNull() {
        UserSave userSave = Creator.newUserSave(
                1,
                null,
                "Илья",
                "Петрович",
                "Админ",
                "+7 123 123-12-12",
                "12312333",
                "Паспорт",
                new Date(),
                (short) 21,
                true
        );
        assertFalse(validate(userSave, "firstName", NotNull.class));
    }

    @Test
    public void validateFirstName_min() {
        UserSave userSave = Creator.newUserSave(
                1,
                "",
                "Илья",
                "Петрович",
                "Админ",
                "+7 123 123-12-12",
                "12312333",
                "Паспорт",
                new Date(),
                (short) 21,
                true
        );
        assertFalse(validate(userSave, "firstName", Size.class));
    }

    @Test
    public void validatePosition_notNull() {
        UserSave userSave = Creator.newUserSave(
                1,
                "Мослов",
                "Илья",
                "Петрович",
                null,
                "+7 123 123-12-12",
                "12312333",
                "Паспорт",
                new Date(),
                (short) 21,
                true
        );
        assertFalse(validate(userSave, "position", NotNull.class));
    }


}