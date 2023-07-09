package com.sicredi.votingservice.service.exception;

public class EntityNotFoundException extends AbstractException {

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message, Integer messageCode) {
        super(message, messageCode);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message, Integer messageCode, Object data) {
        super(message, messageCode, data);
    }

    public EntityNotFoundException(String message, Integer messageCode, Object data, Throwable e) {
        super(message, messageCode, data, e);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

    protected EntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}