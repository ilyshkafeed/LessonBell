package ru.bellintegrator.practice.utilits;

public class PhoneUtility {

    /**
     * Стантартизирует строку номера телефона
     * Применяеться только для российских номеров.
     *
     * @param phone номер телефона
     * @return отформатированый номер телефона
     */
    public static String phoneToStandard(String phone) {
        String numberOnly = phone.replaceAll("[^0-9+]+", "");
        numberOnly = numberOnly.substring(numberOnly.startsWith("8") ? 1 : 2);
        StringBuilder number = new StringBuilder("+7 ");
        number.append(numberOnly, 0, 3).append(' ');
        number.append(numberOnly, 3, 6).append('-');
        number.append(numberOnly, 6, 8).append('-');
        number.append(numberOnly, 8, 10);
        return number.toString();
    }
}
