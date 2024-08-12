package com.sicredi.votingservice.service;

import com.sicredi.votingservice.service.exception.UserNotAllowedToVoteException;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class NationalIdService {
    private static final String NATIONAL_ID_API_URL = "https://user-info.herokupapp.com/users/";

    public boolean canVote(String nationalId) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<NationalIdResponse> response = restTemplate.getForEntity(NATIONAL_ID_API_URL + nationalId, NationalIdResponse.class);
            return response.getBody().getStatus() == Status.ABLE_TO_VOTE;
        } catch (RestClientException e) {
            throw new UserNotAllowedToVoteException();
        }
    }
}

    @Data
    class NationalIdResponse {
        private Status status;
    }

    enum Status {
        ABLE_TO_VOTE, UNABLE_TO_VOTE
    }

