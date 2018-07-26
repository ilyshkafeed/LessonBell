package ru.bellintegrator.practice.api.user.findings;


import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.practice.utilits.ValidateUtilits;
import ru.bellintegrator.practice.validator.Phone;
import ru.bellintegrator.practice.validator.RegEx;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserSave {


    @NotNull(message = "Поле 'name' не может быть пустым")
    @Size(min = 1, max = 50, message = "Размер 'name' должен быть от 1 до 50 символов")
    @RegEx(value = ValidateUtilits.REGEX_PATTERN_NAME, message = "В имени присудствуют запрещеные символы")
    private String name;


    private Integer orgId;

    @NotNull(message = "Поле 'address' не может быть пустым")
    @Size(max = 255, message = "Размер 'address' не должно привышать 255 символов")
    private String address;

    @Phone(message = "Введен неправильный телефон")
    private String phone;

    @JsonProperty("isActive")
    private Boolean isActive;


    @NotNull
    public String getName() {
        return name;
    }


    @NotNull
    public String getAddress() {
        return address;
    }


    public String getPhone() {
        return phone;
    }


    public Integer getOrgId() {
        return orgId;
    }

    public Boolean isActive() {
        return isActive;
    }
}
