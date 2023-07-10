package com.sicredi.votingservice.controller;

import com.sicredi.votingservice.model.VotingSession;
import com.sicredi.votingservice.service.VotingSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voting-session")
@RequiredArgsConstructor
public class VotingSessionController {

    private final VotingSessionService votingSessionService;

    @PostMapping
    public ResponseEntity<?> createNewVotingSession(@RequestBody VotingSession session) {
        votingSessionService.create(session);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> results(@RequestParam Long id) {
        return ResponseEntity.ok(this.votingSessionService.checkResults(id));
    }
}
