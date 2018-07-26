package ru.bellintegrator.practice.api.user.model;


import ru.bellintegrator.practice.api.office.model.Office;
import ru.bellintegrator.practice.api.organization.model.Organization;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(User.class)
public abstract class User_ {
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, Office> firstName;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> middleName;
    public static volatile SingularAttribute<User, String> position;
    public static volatile SingularAttribute<User, Integer> docCode;
    public static volatile SingularAttribute<User, String> docNumber;
    public static volatile SingularAttribute<User, Date> docDate;
    public static volatile SingularAttribute<User, Integer> citizenshipCode;
    public static volatile SingularAttribute<User, Boolean> isIdentified;
}
