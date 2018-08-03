package ru.bellintegrator.practice.api.user.findings;

import Utilites.Creator;
import Utilites.ValidateTest;
import org.junit.Before;
import org.junit.Test;
import ru.bellintegrator.practice.validator.Phone;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserUpdateTest extends ValidateTest {
    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validateObj_ok() {
        UserUpdate userSave = Creator.newUserUpdate(
                1,
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
    public void validateId_notNull() {
        UserUpdate userUpdate = Creator.newUserUpdate(
                null,
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
        assertFalse(validate(userUpdate, "id", NotNull.class));
    }

    @Test
    public void validateFirstName_notNull() {
        UserUpdate userUpdate = Creator.newUserUpdate(
                1,
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
        assertFalse(validate(userUpdate, "firstName", NotNull.class));
    }

    @Test
    public void validateFirstName_min() {
        UserUpdate userUpdate = Creator.newUserUpdate(
                1,
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
        assertFalse(validate(userUpdate, "firstName", Size.class));
    }

    @Test
    public void validateЗosition_notNull() {
        UserUpdate userUpdate = Creator.newUserUpdate(
                1,
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
        assertFalse(validate(userUpdate, "position", NotNull.class));
    }


    @Test
    public void validatePhone__sizeMax() {
        UserUpdate userUpdate = Creator.newUserUpdate(
                1,
                1,
                "Мослов",
                "Илья",
                "Петрович",
                "Админ",
                "+712312312122",
                "12312333",
                "Паспорт",
                new Date(),
                (short) 21,
                true
        );
        assertFalse(validate(userUpdate, "phone", Phone.class));
    }

    @Test
    public void validatePhone__sizeMin() {
        UserUpdate userUpdate = Creator.newUserUpdate(
                1,
                1,
                "Мослов",
                "Илья",
                "Петрович",
                "Админ",
                "+7123123121",
                "12312333",
                "Паспорт",
                new Date(),
                (short) 21,
                true
        );
        assertFalse(validate(userUpdate, "phone", Phone.class));
    }

}