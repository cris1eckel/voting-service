package com.sicredi.votingservice.service;

import com.sicredi.votingservice.mapper.VotingTopicMapper;
import com.sicredi.votingservice.model.VotingTopic;
import com.sicredi.votingservice.repository.VotingTopicRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class VotingTopicService {

    private final VotingTopicRepository votingTopicRepository;

    private final VotingTopicMapper mapper;

    public void create(VotingTopic topic) {
        log.info("Creating a new voting topic with the following data: {}", topic);
        this.votingTopicRepository.save(mapper.toEntity(topic));
    }

    public VotingTopic findById(Long id) {
        return mapper.toModel(votingTopicRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
}
