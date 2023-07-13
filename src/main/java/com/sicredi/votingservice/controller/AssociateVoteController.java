package com.sicredi.votingservice.controller;

import com.sicredi.votingservice.model.AssociateVote;
import com.sicredi.votingservice.service.AssociateVoteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
@RequiredArgsConstructor
public class AssociateVoteController {

    private final AssociateVoteService votingService;

    /**
     * *
     * Saves a vote.
     * @param vote
     */
    @Operation(description = "Create a new associate vote.")
    @PostMapping
    ResponseEntity<?> create(@RequestBody AssociateVote vote){
        this.votingService.create(vote);
        return ResponseEntity.ok().build();
    }
}
