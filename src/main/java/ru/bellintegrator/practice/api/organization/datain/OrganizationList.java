package ru.bellintegrator.practice.api.organization.datain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.practice.api.Validation;

public class OrganizationList implements Validation {



    private String inn;
    private String name;
    private Boolean active;


    public OrganizationList() {
    }

    @Override
    public boolean validate() {
        return name != null;
    }

    public String getInn() {
        return inn;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("isActive")
    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "OrganizationList{" +
                "inn='" + inn + '\'' +
                ", name='" + name + '\'' +
                ", isActive=" + active +
                '}';
    }
}
