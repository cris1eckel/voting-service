package com.sicredi.votingservice.model;

import com.sicredi.votingservice.entity.VotingTopicEntity;
import lombok.Data;

@Data
public class AssociateVote {

    Long id;

    VotingTopicEntity votingTopic;

    Long associateCode;

    Boolean vote;

    String nationalId;
}
