package com.sicredi.votingservice.controller;

import com.sicredi.votingservice.model.VotingTopic;
import com.sicredi.votingservice.service.VotingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voting")
@RequiredArgsConstructor
public class VotingController {

    private final VotingService votingService;

    @PostMapping
    public ResponseEntity<?> createNewTopic(@RequestBody VotingTopic topic) {
        votingService.create(topic);
        return ResponseEntity.ok().build();
    }
}
