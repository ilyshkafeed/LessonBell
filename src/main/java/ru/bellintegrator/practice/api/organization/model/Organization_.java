package ru.bellintegrator.practice.api.organization.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Organization.class)
public abstract class Organization_ {

    //    private static volatile SingularAttribute<Organization, Integer> version;
    public static volatile SingularAttribute<Organization, Integer> id;
    public static volatile SingularAttribute<Organization, String> name;
    public static volatile SingularAttribute<Organization, String> fullName;
    public static volatile SingularAttribute<Organization, String> inn;
    public static volatile SingularAttribute<Organization, String> kpp;
    public static volatile SingularAttribute<Organization, String> address;
    public static volatile SingularAttribute<Organization, String> phone;
    public static volatile SingularAttribute<Organization, Boolean> isActive;

}
