package com.sicredi.votingservice.service.exception;

public class VotingSessionInvalidDateException extends AbstractException {

    private static final long serialVersionUID = 1L;

    public VotingSessionInvalidDateException() {
        super();
    }

    public VotingSessionInvalidDateException(String message, Integer messageCode) {
        super(message, messageCode);
    }

    public VotingSessionInvalidDateException(String message) {
        super(message);
    }

    public VotingSessionInvalidDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public VotingSessionInvalidDateException(String message, Integer messageCode, Object data) {
        super(message, messageCode, data);
    }

    public VotingSessionInvalidDateException(String message, Integer messageCode, Object data, Throwable e) {
        super(message, messageCode, data, e);
    }

    public VotingSessionInvalidDateException(Throwable cause) {
        super(cause);
    }

    protected VotingSessionInvalidDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
