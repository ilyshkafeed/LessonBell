package ru.bellintegrator.practice.api.office.model;

import ru.bellintegrator.practice.api.organization.model.Organization;

import javax.persistence.PreRemove;

public class OfficeListener {

    @PreRemove
    public void userPreRemove(Office ob) {
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> Pre Remove Office : " + ob.getName());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
    }

}
