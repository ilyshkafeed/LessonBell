package ru.bellintegrator.practice.api.view;

public class DataView implements StaticView {
    Object data;

    public DataView() {
    }

    public DataView(Object data) {
        this.data = data;
    }
}
