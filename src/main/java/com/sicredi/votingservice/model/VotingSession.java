package com.sicredi.votingservice.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class VotingSession {

    Long id;

    VotingTopic votingTopic;

    LocalDateTime startDate;

    LocalDateTime endDate;
}
