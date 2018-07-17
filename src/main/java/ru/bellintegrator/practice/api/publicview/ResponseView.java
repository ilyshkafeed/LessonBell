package ru.bellintegrator.practice.api.publicview;

public class ResponseView implements StaticView {
    boolean success;

    public ResponseView() {
    }

    public ResponseView(boolean success) {
        this.success = success;
    }
}
