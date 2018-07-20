package ru.bellintegrator.practice.api.view;

public class ResponseView implements StaticView {
    boolean success;

    public ResponseView() {
    }

    public ResponseView(boolean success) {
        this.success = success;
    }
}
