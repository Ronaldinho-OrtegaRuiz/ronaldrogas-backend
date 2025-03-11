package com.ronaldrogas.backend.users.infrastructure.persistence.mappers;

import com.ronaldrogas.backend.users.domain.models.Phone;
import com.ronaldrogas.backend.users.infrastructure.persistence.entities.PhoneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    @Mapping(target = "user", ignore = true) // Evita la recursión infinita
    Phone toPhone(PhoneEntity phoneEntity);

    @Mapping(target = "user", ignore = true) // Evita la recursión infinita
    PhoneEntity toEntity(Phone phone);
}
