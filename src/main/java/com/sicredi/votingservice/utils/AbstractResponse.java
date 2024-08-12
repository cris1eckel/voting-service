package com.sicredi.votingservice.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractResponse<T> {

    private String message;

    private Integer messageCode;

    private T data;

    public AbstractResponse(T data) {
        this.data = data;
    }

    public AbstractResponse(String message, Integer messageCode) {
        this.message = message;
        this.messageCode = messageCode;
    }
}
