package ru.bellintegrator.practice.api.docs.model;

import javax.persistence.*;

@Entity
public class Doc {


    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @Column(unique = true)
    private byte code;

    @Column
    private String name;



    //getters and setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
