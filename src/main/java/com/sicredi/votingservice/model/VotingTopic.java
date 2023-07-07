package com.sicredi.votingservice.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class VotingTopic {

    Long id;

    String subject;

    LocalDateTime startDate;

    LocalDateTime endDate;
}
