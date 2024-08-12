package com.sicredi.votingservice.repository;

import com.sicredi.votingservice.entity.VotingSessionEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingSessionRepository extends CrudRepository<VotingSessionEntity, Long> {

    Optional<VotingSessionEntity> findByVotingTopicId(Long votingTopicId);

}
