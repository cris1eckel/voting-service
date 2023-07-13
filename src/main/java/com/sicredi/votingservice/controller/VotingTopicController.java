package com.sicredi.votingservice.controller;

import com.sicredi.votingservice.model.VotingTopic;
import com.sicredi.votingservice.service.VotingTopicService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voting-topic")
@RequiredArgsConstructor
public class VotingTopicController {

    private final VotingTopicService votingTopicService;

    /**
     * *
     * Creates a new voting topic.
     * @param topic
     */
    @Operation(description = "Creates a new voting topic")
    @PostMapping
    public ResponseEntity<?> createNewTopic(@RequestBody VotingTopic topic) {
        votingTopicService.create(topic);
        return ResponseEntity.ok().build();
    }
}
