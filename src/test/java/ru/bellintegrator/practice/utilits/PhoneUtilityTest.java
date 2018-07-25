package ru.bellintegrator.practice.utilits;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhoneUtilityTest {

    @Test
    public void testPhoneToStandard_Seven() {
        String number = "+7 (800) 1234567";
        String filter = PhoneUtility.phoneToStandard(number);

        assertEquals("+7 800 123-45-67", filter);
    }

    @Test
    public void testPhoneToStandard_Eight() {
        String number = "8 800 123 45 67";
        String filter = PhoneUtility.phoneToStandard(number);

        assertEquals("+7 800 123-45-67", filter);
    }


}