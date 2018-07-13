package ru.bellintegrator.practice.api.view;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

public class UserView {


    public long id;
    public long officeId;
    public String firstName;
    public String secondName;
    public String middleName;
    // Должность. Либо статическое перечисление enum, либо строка с название должности, либо непонятное число.
    public String position;
    // Код чегото. Предпологаю это число. но не знаю какой длины. Поэтому предположу что int, а дальше по делу.
    public int docCode;
    // агуглил. узнал что код гражданства состоит из 3 букв. тут либо enum/ т к есть определенное еолличество. либо просто строку с размером 3.
    @Size(max = 3)
    public String citizenshipCode;
    public String phone;
    public boolean isActive;


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", officeId=" + officeId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", docCode=" + docCode +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}