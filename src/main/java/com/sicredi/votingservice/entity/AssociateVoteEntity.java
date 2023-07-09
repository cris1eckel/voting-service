package com.sicredi.votingservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity(name = "associate_votes")
public class AssociateVoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "voting_topic_id")
    private VotingTopicEntity votingTopic;

    @Column(name = "associate_code")
    private Long associateCode;

    @Column
    private Boolean vote;

}
