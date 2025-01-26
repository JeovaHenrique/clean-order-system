package com.cleanordersystem.authentication.adapters.persistence.mappes;

import com.cleanordersystem.authentication.adapters.persistence.entities.UserEntity;
import com.cleanordersystem.authentication.core.domain.models.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User toDomain(UserEntity userEntity);

    UserEntity toEntity(User user);
}
