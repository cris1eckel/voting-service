package com.sicredi.votingservice.service;

import com.sicredi.votingservice.model.VotingTopic;
import com.sicredi.votingservice.repository.VotingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotingService {

    private final VotingRepository votingRepository;

    private final VotingTopicMapper mapper;

    public void create(VotingTopic topic) {
        this.votingRepository.save(mapper.toEntity(topic));
    }
}
