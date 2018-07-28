package ru.bellintegrator.practice.api.user.model;

import ru.bellintegrator.practice.api.organization.model.Organization;

import javax.persistence.PreRemove;

public class UserListener {

    @PreRemove
    public void userPreRemove(User ob) {
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> Pre Remove User : " + ob.getLastName());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
    }

}
