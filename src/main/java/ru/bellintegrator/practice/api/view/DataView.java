package ru.bellintegrator.practice.api.view;

public class DataView implements StaticView {
    private Object data;

    public DataView() {
    }

    public DataView(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
