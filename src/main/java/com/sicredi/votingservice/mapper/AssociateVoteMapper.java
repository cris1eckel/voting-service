package com.sicredi.votingservice.mapper;

import com.sicredi.votingservice.entity.AssociateVoteEntity;
import com.sicredi.votingservice.model.AssociateVote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssociateVoteMapper {

    AssociateVoteEntity toEntity (AssociateVote model);

    AssociateVote toModel(AssociateVoteEntity entity);
}
