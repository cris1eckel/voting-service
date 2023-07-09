package com.sicredi.votingservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "voting_topics")
public class VotingTopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String subject;

    @OneToMany(mappedBy = "votingTopic", cascade = CascadeType.ALL)
    private List<AssociateVoteEntity> votes;
}
