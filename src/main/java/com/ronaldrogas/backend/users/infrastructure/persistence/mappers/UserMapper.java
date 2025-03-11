package com.ronaldrogas.backend.users.infrastructure.persistence.mappers;

import com.ronaldrogas.backend.users.domain.models.User;
import com.ronaldrogas.backend.users.infrastructure.persistence.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, PhoneMapper.class})
public interface UserMapper {
    User toUser(UserEntity userEntity);
    UserEntity toEntity(User user);
}
