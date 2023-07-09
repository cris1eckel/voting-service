package com.sicredi.votingservice.service;

import com.sicredi.votingservice.entity.VotingSessionEntity;
import com.sicredi.votingservice.mapper.VotingSessionMapper;
import com.sicredi.votingservice.model.VotingSession;
import com.sicredi.votingservice.repository.VotingSessionRepository;
import com.sicredi.votingservice.service.exception.VotingSessionAlreadyExists;
import com.sicredi.votingservice.service.exception.VotingSessionInvalidDateException;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VotingSessionService {

    private final VotingSessionRepository votingSessionRepository;

    private final VotingTopicService votingTopicService;

    private final VotingSessionMapper mapper;

    @Transactional
    public void create(VotingSession session) {
        var votingTopic = votingTopicService.findById(session.getVotingTopic().getId());
        session.setVotingTopic(votingTopic);

        var votingSession = new VotingSession();

        try {
            votingSession = findVotingSessionByVotingTopicId(votingTopic.getId());
        } catch (EntityNotFoundException e) {
            votingSession = null;
        }

        if (votingSession != null) {
            throw new VotingSessionAlreadyExists();
        }

        var startDate = session.getStartDate();
        if (startDate == null) {
            startDate = LocalDateTime.now();
            session.setStartDate(startDate);
        }

        var endDate = session.getStartDate();
        if (endDate == null) {
            endDate = startDate.plusMinutes(1L);
            session.setEndDate(endDate);
        }

        if(startDate.isAfter(endDate)){
            throw new VotingSessionInvalidDateException();
        }
        VotingSessionEntity entity = mapper.toEntity(session);
        this.votingSessionRepository.save(entity);
    }

    public VotingSession findVotingSessionByVotingTopicId(Long votingTopicId) {
        return mapper.toModel(this.votingSessionRepository.findByVotingTopicId(votingTopicId).orElseThrow(EntityNotFoundException::new));
    }

}
