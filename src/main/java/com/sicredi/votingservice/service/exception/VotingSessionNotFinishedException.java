package com.sicredi.votingservice.service.exception;

public class VotingSessionNotFinishedException extends AbstractException {
    public VotingSessionNotFinishedException() {
        super();
    }

    public VotingSessionNotFinishedException(String message, Integer messageCode) {
        super(message, messageCode);
    }

    public VotingSessionNotFinishedException(String message) {
        super(message);
    }

    public VotingSessionNotFinishedException(String message, Throwable cause) {
        super(message, cause);
    }

    public VotingSessionNotFinishedException(String message, Integer messageCode, Object data) {
        super(message, messageCode, data);
    }

    public VotingSessionNotFinishedException(String message, Integer messageCode, Object data, Throwable e) {
        super(message, messageCode, data, e);
    }

    public VotingSessionNotFinishedException(Throwable cause) {
        super(cause);
    }

    protected VotingSessionNotFinishedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
