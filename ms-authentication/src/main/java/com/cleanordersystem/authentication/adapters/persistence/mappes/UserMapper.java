package com.cleanordersystem.authentication.adapters.persistence.mappes;

import com.cleanordersystem.authentication.adapters.persistence.entities.UserEntity;
import com.cleanordersystem.authentication.core.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDomain(UserEntity userEntity);

    UserEntity toEntity(User user);
}
