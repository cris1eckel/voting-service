package com.sicredi.votingservice.service;

import com.sicredi.votingservice.mapper.AssociateVoteMapper;
import com.sicredi.votingservice.model.AssociateVote;
import com.sicredi.votingservice.model.ResultsResponse;
import com.sicredi.votingservice.repository.AssociateVoteRepository;
import com.sicredi.votingservice.service.exception.UserAlreadyVotedException;
import com.sicredi.votingservice.service.exception.VotingSessionAlreadyFinishedException;
import com.sicredi.votingservice.service.exception.VotingSessionNotStartedException;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AssociateVoteService {

    private final AssociateVoteRepository associateVoteRepository;

    private final VotingTopicService votingTopicService;

    private final VotingSessionService votingSessionService;

    private final AssociateVoteMapper mapper;

    @Transactional
    public void create(AssociateVote vote) {
        var timeNow = LocalDateTime.now();

        var votingTopic = this.votingTopicService.findById(vote.getVotingTopic().getId());

        var votingSession = votingSessionService.findVotingSessionByVotingTopicId(votingTopic.getId());

        if (votingSession == null || timeNow.isBefore(votingSession.getStartDate())) {
            throw new VotingSessionNotStartedException();
        }

        if (timeNow.isAfter(votingSession.getEndDate())) {
            throw new VotingSessionAlreadyFinishedException();
        }

        var associateVote = this.associateVoteRepository.findByVotingTopicIdAndAssociateCode(votingTopic.getId(), vote.getAssociateCode());

        if (associateVote.isPresent()) {
            throw new UserAlreadyVotedException();
        }

        this.associateVoteRepository.save(this.mapper.toEntity(vote));
    }
}
