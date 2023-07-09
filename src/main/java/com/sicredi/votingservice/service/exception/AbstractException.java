package com.sicredi.votingservice.service.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class AbstractException extends RuntimeException {

    private String message;
    private Integer messageCode;
    private Object data;

    AbstractException(String message, Integer messageCode) {
        super(message);
        this.message = message;
        this.messageCode = messageCode;
    }

    AbstractException(String message, Integer messageCode, Object data) {
        super(message);
        this.message = message;
        this.messageCode = messageCode;
        this.data = data;
    }

    AbstractException(String message, Integer messageCode, Throwable e) {
        super(message, e);
        this.message = message;
        this.messageCode = messageCode;
    }

    AbstractException(String message, Integer messageCode, Object data, Throwable e) {
        super(message, e);
        this.message = message;
        this.messageCode = messageCode;
        this.data = data;
    }

    AbstractException(String message) {
        super();
        this.message = message;
    }

    AbstractException(Integer messageCode) {
        super();
        this.messageCode = messageCode;
    }

    AbstractException() {
        super();
    }

    AbstractException(String message, Throwable cause) {
        super(message, cause);
    }

    AbstractException(Throwable cause) {
        super(cause);
    }

    AbstractException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}