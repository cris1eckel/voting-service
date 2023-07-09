package com.sicredi.votingservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "voting_sessions")
public class VotingSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "voting_topic_id")
    private VotingTopicEntity votingTopic;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

}
