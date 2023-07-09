package com.sicredi.votingservice.service.exception;

public class UserAlreadyVotedException extends AbstractException {

    private static final long serialVersionUID = 1L;


    public UserAlreadyVotedException() {
        super();
    }

    public UserAlreadyVotedException(String message, Integer messageCode) {
        super(message, messageCode);
    }

    public UserAlreadyVotedException(String message) {
        super(message);
    }

    public UserAlreadyVotedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyVotedException(String message, Integer messageCode, Object data) {
        super(message, messageCode, data);
    }

    public UserAlreadyVotedException(String message, Integer messageCode, Object data, Throwable e) {
        super(message, messageCode, data, e);
    }

    public UserAlreadyVotedException(Throwable cause) {
        super(cause);
    }

    protected UserAlreadyVotedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
