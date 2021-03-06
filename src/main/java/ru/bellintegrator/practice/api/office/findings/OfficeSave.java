package ru.bellintegrator.practice.api.office.findings;


import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.practice.api.utilits.ValidateUtilits;
import ru.bellintegrator.practice.validator.Phone;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class OfficeSave {


    @NotNull(message = "Поле 'name' не может быть пустым")
    @Size(min = 1, max = 50, message = "Размер 'name' должен быть от 1 до 50 символов")
    @Pattern(regexp  = ValidateUtilits.REGEX_PATTERN_NAME, message = "В имени присудствуют запрещеные символы")
    private String name;

    @NotNull(message = "Поле 'orgId' не может быть пустым")
    private Integer orgId;

    @NotNull(message = "Поле 'address' не может быть пустым")
    @Size(max = 255, message = "Размер 'address' не должно привышать 255 символов")
    private String address;

    @Phone(message = "Введен неправильный телефон")
    private String phone;

    @JsonProperty("isActive")
    private Boolean isActive;



    public String getName() {
        return name;
    }



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
