package com.sicredi.votingservice.model;

import com.sicredi.votingservice.entity.AssociateVoteEntity;
import java.util.List;
import lombok.Data;

@Data
public class VotingTopic {

    Long id;

    String subject;

    List<AssociateVoteEntity> votes;
}
