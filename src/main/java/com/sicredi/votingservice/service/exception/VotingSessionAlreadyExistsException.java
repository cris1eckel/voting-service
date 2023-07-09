package com.sicredi.votingservice.service.exception;

public class VotingSessionAlreadyExistsException extends AbstractException {

    private static final long serialVersionUID = 1L;

    public VotingSessionAlreadyExistsException() {
        super();
    }

    public VotingSessionAlreadyExistsException(String message, Integer messageCode) {
        super(message, messageCode);
    }

    public VotingSessionAlreadyExistsException(String message) {
        super(message);
    }

    public VotingSessionAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public VotingSessionAlreadyExistsException(String message, Integer messageCode, Object data) {
        super(message, messageCode, data);
    }

    public VotingSessionAlreadyExistsException(String message, Integer messageCode, Object data, Throwable e) {
        super(message, messageCode, data, e);
    }

    public VotingSessionAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected VotingSessionAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
