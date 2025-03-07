package com.ronaldrogas.backend.users.infrastructure.persistence.mappers;

import com.ronaldrogas.backend.users.domain.models.User;
import com.ronaldrogas.backend.users.domain.models.Phone;
import com.ronaldrogas.backend.users.domain.models.Address;
import com.ronaldrogas.backend.users.infrastructure.persistence.entities.UserEntity;
import com.ronaldrogas.backend.users.infrastructure.persistence.entities.PhoneEntity;
import com.ronaldrogas.backend.users.infrastructure.persistence.entities.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {

    User toUser(UserEntity userEntity);
    
    @Mapping(target = "phones", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    UserEntity toEntity(User user);

    Phone toPhone(PhoneEntity phoneEntity);
    
    @Mapping(target = "user", ignore = true)
    PhoneEntity toEntity(Phone phone);

    Address toAddress(AddressEntity addressEntity);
    
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "country", constant = "Colombia")
    AddressEntity toEntity(Address address);
}
