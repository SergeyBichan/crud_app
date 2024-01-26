package ru.myself.crud_app.exception;

public class ResourceIsFoundException extends RuntimeException {
    public ResourceIsFoundException(String message) {
        super(message);
    }
}
