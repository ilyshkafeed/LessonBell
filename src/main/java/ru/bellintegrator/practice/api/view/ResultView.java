package ru.bellintegrator.practice.api.view;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResultView implements StaticView {
    @JsonIgnore
    public static final ResultView SUCCESS = new ResultView("success");


    private String result;

    public ResultView(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }


}
