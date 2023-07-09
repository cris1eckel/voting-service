package com.sicredi.votingservice.service.exception;

public class VotingSessionAlreadyFinishedException extends AbstractException {

    private static final long serialVersionUID = 1L;

    public VotingSessionAlreadyFinishedException() {
        super();
    }

    public VotingSessionAlreadyFinishedException(String message, Integer messageCode) {
        super(message, messageCode);
    }

    public VotingSessionAlreadyFinishedException(String message) {
        super(message);
    }

    public VotingSessionAlreadyFinishedException(String message, Throwable cause) {
        super(message, cause);
    }

    public VotingSessionAlreadyFinishedException(String message, Integer messageCode, Object data) {
        super(message, messageCode, data);
    }

    public VotingSessionAlreadyFinishedException(String message, Integer messageCode, Object data, Throwable e) {
        super(message, messageCode, data, e);
    }

    public VotingSessionAlreadyFinishedException(Throwable cause) {
        super(cause);
    }

    protected VotingSessionAlreadyFinishedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
