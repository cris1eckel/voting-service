package com.sicredi.votingservice.service;

import com.sicredi.votingservice.entity.AssociateVoteEntity;
import com.sicredi.votingservice.entity.VotingSessionEntity;
import com.sicredi.votingservice.mapper.VotingSessionMapper;
import com.sicredi.votingservice.model.ResultsResponse;
import com.sicredi.votingservice.model.VotingSession;
import com.sicredi.votingservice.repository.VotingSessionRepository;
import com.sicredi.votingservice.service.exception.VotingSessionAlreadyExistsException;
import com.sicredi.votingservice.service.exception.VotingSessionInvalidDateException;
import com.sicredi.votingservice.service.exception.VotingSessionNotFinishedException;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class VotingSessionService {

    private final VotingSessionRepository votingSessionRepository;

    private final VotingTopicService votingTopicService;

    private final VotingSessionMapper mapper;

    @Transactional
    public VotingSession create(VotingSession session) {
        log.info("Creating a new voting session with the following data: {}", session);
        var votingTopic = votingTopicService.findById(session.getVotingTopic().getId());
        session.setVotingTopic(votingTopic);

        var votingSession = new VotingSession();

        try {
            votingSession = findVotingSessionByVotingTopicId(votingTopic.getId());
        } catch (EntityNotFoundException e) {
            votingSession = null;
        }

        if (votingSession != null) {
            throw new VotingSessionAlreadyExistsException();
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

        if (startDate.isAfter(endDate)) {
            throw new VotingSessionInvalidDateException();
        }
        VotingSessionEntity entity = mapper.toEntity(session);
        return mapper.toModel(this.votingSessionRepository.save(entity));
    }

    public VotingSession findVotingSessionByVotingTopicId(Long votingTopicId) {
        return mapper.toModel(this.votingSessionRepository.findByVotingTopicId(votingTopicId).orElseThrow(EntityNotFoundException::new));
    }

    public VotingSession findById(Long id) {
        return mapper.toModel(this.votingSessionRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public ResultsResponse checkResults(Long votingSessionId) {
        log.info("Retrieving results for vote session of id: {}}", votingSessionId);
        var now = LocalDateTime.now();

        var votingSession = findById(votingSessionId);

        if (now.isBefore(votingSession.getEndDate())) {
            throw new VotingSessionNotFinishedException();
        }
        int positiveVote = 0;
        int negativeVote = 0;
        boolean approved = false;

        var voteList = votingSession.getVotingTopic().getVotes();
        for (AssociateVoteEntity voteEntity : voteList) {
            if (voteEntity.getVote()) {
                positiveVote++;
            } else {
                negativeVote++;
            }
        }
        if (positiveVote > negativeVote) {
            approved = true;

        }
        var subject = votingSession.getVotingTopic().getSubject();

        return ResultsResponse.builder()
                .positiveVotes(positiveVote)
                .negativeVotes(negativeVote)
                .subject(subject)
                .approved(approved)
                .build();
    }
}
