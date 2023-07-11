package com.sicredi.votingservice.service.exception.handler;

import com.sicredi.votingservice.service.exception.EntityNotFoundException;
import com.sicredi.votingservice.service.exception.UserAlreadyVotedException;
import com.sicredi.votingservice.service.exception.UserNotAllowedToVoteException;
import com.sicredi.votingservice.service.exception.VotingSessionAlreadyExistsException;
import com.sicredi.votingservice.service.exception.VotingSessionAlreadyFinishedException;
import com.sicredi.votingservice.service.exception.VotingSessionInvalidDateException;
import com.sicredi.votingservice.service.exception.VotingSessionNotFinishedException;
import com.sicredi.votingservice.service.exception.VotingSessionNotStartedException;
import com.sicredi.votingservice.utils.AbstractResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class CoreExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyVotedException.class)
    public ResponseEntity<AbstractResponse> handleUserAlreadyVoted(UserAlreadyVotedException e) {
        log.warn(e.getMessage(), e);
        AbstractResponse response = new AbstractResponse();
        response.setMessage(e.getMessage());
        response.setMessageCode(e.getMessageCode());
        response.setData(e.getData());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotAllowedToVoteException.class)
    public ResponseEntity<AbstractResponse> handleUserNotAllowedToVote(UserNotAllowedToVoteException e) {
        log.warn(e.getMessage(), e);
        AbstractResponse response = new AbstractResponse();
        response.setMessage(e.getMessage());
        response.setMessageCode(e.getMessageCode());
        response.setData(e.getData());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VotingSessionAlreadyExistsException.class)
    public ResponseEntity<AbstractResponse> handleVotingSessionAlreadyExists(VotingSessionAlreadyExistsException e) {
        log.warn(e.getMessage(), e);
        AbstractResponse response = new AbstractResponse();
        response.setMessage(e.getMessage());
        response.setMessageCode(e.getMessageCode());
        response.setData(e.getData());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VotingSessionAlreadyFinishedException.class)
    public ResponseEntity<AbstractResponse> handleVotingSessionAlreadyFinished(VotingSessionAlreadyFinishedException e) {
        log.warn(e.getMessage(), e);
        AbstractResponse response = new AbstractResponse();
        response.setMessage(e.getMessage());
        response.setMessageCode(e.getMessageCode());
        response.setData(e.getData());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VotingSessionInvalidDateException.class)
    public ResponseEntity<AbstractResponse> handleVotingSessionInvalidDate(VotingSessionInvalidDateException e) {
        log.warn(e.getMessage(), e);
        AbstractResponse response = new AbstractResponse();
        response.setMessage(e.getMessage());
        response.setMessageCode(e.getMessageCode());
        response.setData(e.getData());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VotingSessionNotStartedException.class)
    public ResponseEntity<AbstractResponse> handleVotingSessionNotStarted(VotingSessionNotStartedException e) {
        log.warn(e.getMessage(), e);
        AbstractResponse response = new AbstractResponse();
        response.setMessage(e.getMessage());
        response.setMessageCode(e.getMessageCode());
        response.setData(e.getData());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VotingSessionNotFinishedException.class)
    public ResponseEntity<AbstractResponse> handleVotingSessionNotFinish(VotingSessionNotFinishedException e) {
        log.warn(e.getMessage(), e);
        AbstractResponse response = new AbstractResponse();
        response.setMessage(e.getMessage());
        response.setMessageCode(e.getMessageCode());
        response.setData(e.getData());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<AbstractResponse> handleEntityNotFoundException(EntityNotFoundException e) {
        log.warn("{} - {} at {}", e.getClass().getSimpleName(), e.getMessage(), e.getStackTrace()[0]);
        AbstractResponse response = new AbstractResponse();
        response.setMessage(e.getMessage());
        response.setMessageCode(e.getMessageCode());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AbstractResponse> handleException(Exception e) {
        log.error(e.getMessage(), e);
        AbstractResponse response = new AbstractResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.warn(e.getMessage(), e);
        Class<?> type = e.getRequiredType();
        AbstractResponse response = new AbstractResponse();
        if (type.isEnum()) {
            response.setMessage("The parameter " + e.getName() + " must have a value among : " + StringUtils.join(type.getEnumConstants(), ", "));
        } else {
            response.setMessage("The parameter " + e.getName() + " must be of type " + type.getTypeName());
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
