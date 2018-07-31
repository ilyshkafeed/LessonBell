package ru.bellintegrator.practice.api.office.findings;


import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.practice.api.utilits.ValidateUtilits;
import ru.bellintegrator.practice.validator.Phone;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class OfficeList {
    @NotNull(message = "Поле 'orgId' не может быть пустым")
    private Integer orgId;

    @Size(min = 1, max = 50, message = "Размер 'name' должен быть от 1 до 50 символов")
    @Pattern(regexp = ValidateUtilits.REGEX_PATTERN_NAME, message = "В имени присудствуют запрещеные символы")
    private String name;
    @Phone(message = "Введен неправильный телефон")
    private String phone;

    private Boolean isActive;


    @Override
    public String toString() {
        return "OfficeList{" +
                "orgId=" + orgId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public Integer getOrgId() {
        return orgId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @JsonProperty("isActive")
    public Boolean isActive() {
        return isActive;
    }
}
