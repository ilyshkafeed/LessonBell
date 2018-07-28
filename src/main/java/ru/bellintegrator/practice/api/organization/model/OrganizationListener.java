package ru.bellintegrator.practice.api.organization.model;

import javax.persistence.PreRemove;

public class OrganizationListener {

    @PreRemove
    public void userPreRemove(Organization ob) {
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> Pre Remove Organization : " + ob.getName());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
    }

}
