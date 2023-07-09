package com.sicredi.votingservice.service.exception;

public class VotingSessionNotStartedException extends AbstractException {

    private static final long serialVersionUID = 1L;

    public VotingSessionNotStartedException() {
        super();
    }

    public VotingSessionNotStartedException(String message, Integer messageCode) {
        super(message, messageCode);
    }

    public VotingSessionNotStartedException(String message) {
        super(message);
    }

    public VotingSessionNotStartedException(String message, Throwable cause) {
        super(message, cause);
    }

    public VotingSessionNotStartedException(String message, Integer messageCode, Object data) {
        super(message, messageCode, data);
    }

    public VotingSessionNotStartedException(String message, Integer messageCode, Object data, Throwable e) {
        super(message, messageCode, data, e);
    }

    public VotingSessionNotStartedException(Throwable cause) {
        super(cause);
    }

    protected VotingSessionNotStartedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
