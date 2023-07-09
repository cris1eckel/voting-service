package com.sicredi.votingservice.mapper;

import com.sicredi.votingservice.entity.VotingTopicEntity;
import com.sicredi.votingservice.model.VotingTopic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VotingTopicMapper {

    VotingTopicEntity toEntity (VotingTopic votingTopic);

    VotingTopic toModel (VotingTopicEntity entity);
}
