package com.ronaldrogas.backend.users.infrastructure.persistence.mappers;

import com.ronaldrogas.backend.users.domain.models.Address;
import com.ronaldrogas.backend.users.infrastructure.persistence.entities.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "user", ignore = true) // Evitar ciclos infinitos
    Address toAddress(AddressEntity entity);

    @Mapping(target = "user", ignore = true) // Evitar ciclos infinitos
    AddressEntity toEntity(Address address);
}
