package ru.bellintegrator.practice.api.organization.findings;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.practice.utilits.ValidateUtilits;
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
    @RegEx(value = ValidateUtilits.REGEX_PATTERN_NAME, message = "В имени присудствуют запрещеные символы")
    private String name;

    @Size(min = 10, max = 10, message = "Размер 'inn' должен быть 10")
    private String inn;

    @JsonProperty("isActive")
    private Boolean isActive;


    public OrganizationList() {
    }

    public String getInn() {
        return inn;
    }

    public String getName() {
        return name;
    }

    public Boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "OrganizationList{" +
                "name='" + name + '\'' +
                ", inn='" + inn + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
