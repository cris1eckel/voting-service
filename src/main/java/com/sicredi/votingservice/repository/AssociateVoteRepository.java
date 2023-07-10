package com.sicredi.votingservice.repository;

import com.sicredi.votingservice.entity.AssociateVoteEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AssociateVoteRepository extends CrudRepository<AssociateVoteEntity, Long> {
    Optional<AssociateVoteEntity> findByVotingTopicIdAndAssociateCode(Long votingTopicId, Long associateCode);

}
