package com.sicredi.votingservice.service;

import com.sicredi.votingservice.entity.VotingSessionEntity;
import com.sicredi.votingservice.entity.VotingTopicEntity;
import com.sicredi.votingservice.mapper.VotingSessionMapper;
import com.sicredi.votingservice.model.VotingSession;
import com.sicredi.votingservice.model.VotingTopic;
import com.sicredi.votingservice.repository.VotingSessionRepository;
import com.sicredi.votingservice.service.exception.VotingSessionAlreadyExistsException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VotingSessionServiceTest {

    @InjectMocks
    private VotingSessionService votingSessionService;

    @Mock
    private VotingTopicService votingTopicService;

    @Mock
    private VotingSessionRepository votingSessionRepository;

    @Mock
    private VotingSessionMapper votingSessionMapper;

    @Test
    public void shouldCreateVotingSessionWhenNotExists() {
        Long votingTopicId = 1L;

        VotingTopic votingTopic = new VotingTopic();
        votingTopic.setId(votingTopicId);

        VotingTopicEntity votingTopicEntity = new VotingTopicEntity();
        votingTopicEntity.setId(votingTopicId);

        Long votingSessionId = 1L;

        VotingSession votingSession = new VotingSession();
        votingSession.setId(votingSessionId);
        votingSession.setVotingTopic(votingTopic);

        VotingSessionEntity votingSessionEntity = new VotingSessionEntity();
        votingSessionEntity.setId(votingSessionId);
        votingSessionEntity.setVotingTopic(votingTopicEntity);

        when(votingTopicService.findById(votingTopicId)).thenReturn(votingTopic);
        when(votingSessionRepository.findByVotingTopicId(votingTopicId)).thenReturn(Optional.empty());
        when(votingSessionRepository.save(votingSessionEntity)).thenReturn(votingSessionEntity);
        when(votingSessionMapper.toEntity(votingSession)).thenReturn(votingSessionEntity);
        when(votingSessionMapper.toModel(votingSessionEntity)).thenReturn(votingSession);

        var savedSession = votingSessionService.create(votingSession);

        assertEquals(votingSession, savedSession, "Error while saving voting session.");

    }

    @Test
    public void shouldNotCreateVotingSessionWhenAlreadyExists() {
        Long votingTopicId = 1L;

        VotingTopic votingTopic = new VotingTopic();
        votingTopic.setId(votingTopicId);

        VotingTopicEntity votingTopicEntity = new VotingTopicEntity();
        votingTopicEntity.setId(votingTopicId);

        Long votingSessionId = 1L;

        VotingSession votingSession = new VotingSession();
        votingSession.setId(votingSessionId);
        votingSession.setVotingTopic(votingTopic);

        VotingSessionEntity votingSessionEntity = new VotingSessionEntity();
        votingSessionEntity.setId(votingSessionId);
        votingSessionEntity.setVotingTopic(votingTopicEntity);

        when(votingTopicService.findById(votingTopicId)).thenReturn(votingTopic);
        when(votingSessionRepository.findByVotingTopicId(votingTopicId)).thenReturn(Optional.of(votingSessionEntity));
        when(votingSessionRepository.save(votingSessionEntity)).thenReturn(votingSessionEntity);
        when(votingSessionMapper.toEntity(votingSession)).thenReturn(votingSessionEntity);
        when(votingSessionMapper.toModel(votingSessionEntity)).thenReturn(votingSession);

        assertThrows(VotingSessionAlreadyExistsException.class, () -> votingSessionService.create(votingSession), "Allowed an already existing voting session to be saved");
    }

}