package ru.bellintegrator.practice.api.organization.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class ListView {
    @ApiModelProperty(hidden = true)
    public int id;
    @JsonIgnore
    public String inn;
    public String name;
    public boolean isActive;

    public ListView(){}

    public ListView(int id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }
}
