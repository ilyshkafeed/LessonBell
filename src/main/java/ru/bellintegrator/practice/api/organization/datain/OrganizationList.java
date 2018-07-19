package ru.bellintegrator.practice.api.organization.datain;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.practice.api.Validation;
import ru.bellintegrator.practice.api.exception.RequiredFieldException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OrganizationList implements Validation {
    private String inn;
    private String name;
    private Boolean active;


    public OrganizationList() {
    }

    @Override
    public boolean validate() {
        return !((name == null) || (name.length() == 0));
    }

    @Override
    public RuntimeException getValidateException() {
        List<String> fields = (name == null || name.length() == 0) ? Collections.singletonList("name") : Collections.EMPTY_LIST;
        return new RequiredFieldException(fields);
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
