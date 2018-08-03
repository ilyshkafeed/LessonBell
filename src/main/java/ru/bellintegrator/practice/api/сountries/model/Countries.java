package ru.bellintegrator.practice.api.сountries.model;

import javax.persistence.*;

@Entity(name = "country")
public class Countries {


    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @Column(unique = true)
    private short code;

    @Column
    private String name;



    //getters and setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getCode() {
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
