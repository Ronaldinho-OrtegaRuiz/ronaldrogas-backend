package com.ronaldrogas.backend.users.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Long id;
    private String street;
    private String city;
    private String department;
    private String country;
    private String reference;
} 