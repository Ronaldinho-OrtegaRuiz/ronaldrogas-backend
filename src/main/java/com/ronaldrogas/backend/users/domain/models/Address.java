package com.ronaldrogas.backend.users.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Long id;
    private String street;
    private String city;
    private String department;
    private String country; // = "Colombia";
    private String reference;
    private User user;
}
