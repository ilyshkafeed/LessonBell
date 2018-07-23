package ru.bellintegrator.practice.api.organization.datain;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.practice.api.organization.model.Organization;
import ru.bellintegrator.practice.validator.RegEx;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Класс для входных данных <br>
 * Фильтры для получения списка организаций. <br>
 * Список содержит не все поля.
 */
public class OrganizationList {

    @NotNull(message = "Поле 'name' не может быть пустым")
    @Size(min = 1, max = 50, message = "Размер 'name' должен быть от 1 до 50 символов")
    @RegEx(value = Organization.REGEX_PATTERN_NAME, message = "В имени присудствуют запрещеные символы")
    private String name;

    @Size(min = 10, max = 10, message = "Размер 'inn' должен быть 10")
    private String inn;

    private Boolean active;


    public OrganizationList() {
    }

    public String getInn() {
        return inn;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("isActive")
    public Boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "OrganizationList{" +
                "inn='" + (inn == null ? "" : inn) + '\'' +
                ", name='" + (name == null ? "" : name) + '\'' +
                ", isActive=" + (active == null ? "" : active) +
                '}';
    }
}
