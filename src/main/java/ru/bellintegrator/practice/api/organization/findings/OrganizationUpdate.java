package ru.bellintegrator.practice.api.organization.findings;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.practice.api.utilits.ValidateUtilits;
import ru.bellintegrator.practice.validator.Phone;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OrganizationUpdate {
    @NotNull(message = "Поле 'name' не может быть пустым")
    private Integer id;

    @NotNull(message = "Поле 'name' не может быть пустым")
    @Size(min = 2, max = 50, message = "Размер 'name' должен быть от 2 до 50 символов")
    @Pattern(regexp =  ValidateUtilits.REGEX_PATTERN_NAME, message = "В имени присудствуют запрещеные символы")
    private String name;

    @NotNull(message = "Поле 'fullName' не может быть пустым")
    @Size(min = 2, max = 255, message = "Размер 'name' должен быть от 2 до 255 символов")
    @Pattern(regexp =  ValidateUtilits.REGEX_PATTERN_NAME, message = "В имени присудствуют запрещеные символы")
    private String fullName;

    @NotNull(message = "Поле 'inn' не может быть пустым")
    @Size(min = 10, max = 10, message = "Размер 'name' должен быть 10 символов")
    private String inn;

    @NotNull(message = "Поле 'kpp' не может быть пустым")
    @Size(min = 9, max = 9, message = "Размер 'name' должен быть 9 символов")
    private String kpp;

    @NotNull(message = "Поле 'address' не может быть пустым")
    @Size(max = 255, message = "Поле 'address' не может привышать 255 символов")
    private String address;

    @Size(max = 50, message = "Поле 'phone' не может привышать 50 символов")
    @Phone(message = "Введен неправильный телефон")
    private String phone;

    @JsonProperty("isActive")
    private Boolean isActive;

    public OrganizationUpdate() {
    }

    public OrganizationUpdate(Integer id, String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }


    @Override
    public String toString() {
        return "{" +
                ", id=\"" + id + '\"' +
                ", name=\"" + name + '\"' +
                ", fullName=\"" + fullName + '\"' +
                ", inn=\"" + inn + '\"' +
                ", kpp=\"" + kpp + '\"' +
                ", address=\"" + address + '\"' +
                ", phone=\"" + phone + '\"' +
                ", isActive=\"" + isActive + '\"' +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean isActive() {
        return isActive;
    }
}
