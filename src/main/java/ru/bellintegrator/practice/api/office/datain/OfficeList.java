package ru.bellintegrator.practice.api.office.datain;


import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;

import javax.validation.constraints.NotNull;

public class OfficeList extends EmbeddedLdapProperties.Validation {
    @NotNull
    private int orgId;





}
