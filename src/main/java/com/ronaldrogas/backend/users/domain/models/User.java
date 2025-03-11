package com.ronaldrogas.backend.users.domain.models;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Phone> phones;
    private List<Address> addresses;
}
