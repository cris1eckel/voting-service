package com.sicredi.votingservice.controller;

import com.sicredi.votingservice.messaging.VotingResultsProducer;
import com.sicredi.votingservice.model.VotingSession;
import com.sicredi.votingservice.service.VotingSessionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voting-session")
@RequiredArgsConstructor
public class VotingSessionController {

    private final VotingSessionService votingSessionService;

    private final VotingResultsProducer producer;

    /**
     * *
     * Creates a new voting session.
     *
     * @param session
     */
    @Operation(description = "Create a new voting session")
    @PostMapping
    public ResponseEntity<?> createNewVotingSession(@RequestBody VotingSession session) {
        votingSessionService.create(session);
        return ResponseEntity.ok().build();
    }

    /**
     * *
     * Checks the voting session results.
     *
     * @param id
     * @return ResultsResponse
     */
    @Operation(description = "Retrieves results of a voting session")
    @GetMapping("{id}/results")
    public ResponseEntity<?> results(@PathVariable Long id) {
        var votingSessionResults = this.votingSessionService.checkResults(id);
        producer.send(votingSessionResults.toString());
        return ResponseEntity.ok(votingSessionResults);
    }
}
