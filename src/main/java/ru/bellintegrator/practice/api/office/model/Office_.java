package ru.bellintegrator.practice.api.office.model;


import ru.bellintegrator.practice.api.organization.model.Organization;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Office.class)
public abstract class Office_ {
    public static volatile SingularAttribute<Office, Integer> id;
    public static volatile SingularAttribute<Office, String> name;
    public static volatile SingularAttribute<Office, String> address;
    public static volatile SingularAttribute<Office, String> phone;
    public static volatile SingularAttribute<Office, Organization> organization;
    public static volatile SingularAttribute<Office, Boolean> isActive;
}
