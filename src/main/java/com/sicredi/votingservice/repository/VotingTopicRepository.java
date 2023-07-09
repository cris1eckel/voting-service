package com.sicredi.votingservice.repository;

import com.sicredi.votingservice.entity.VotingTopicEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingTopicRepository extends CrudRepository<VotingTopicEntity, Long> {

}
