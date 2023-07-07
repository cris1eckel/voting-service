package com.sicredi.votingservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity(name = "associate_votes")
public class AssociateVoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "voting_topic_id", nullable = false)
    private VotingTopicEntity votingTopic;

    @Column
    private Boolean vote;

}
