package com.sicredi.votingservice.mapper;

import com.sicredi.votingservice.entity.VotingSessionEntity;
import com.sicredi.votingservice.model.VotingSession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VotingSessionMapper {

    VotingSessionEntity toEntity (VotingSession model);

    VotingSession toModel(VotingSessionEntity entity);
}
