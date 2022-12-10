package org.byt.exception;


import static java.lang.String.format;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String entityName, Long identifier) {
        super(format("%s(%s) not found", entityName, identifier));
    }

    public ObjectNotFoundException(String entityName, String property) {
        super(format("%s(%s) not found", entityName, property));
    }
}
