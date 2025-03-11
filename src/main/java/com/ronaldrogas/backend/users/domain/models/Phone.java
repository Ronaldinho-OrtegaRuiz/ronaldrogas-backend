package com.ronaldrogas.backend.users.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    private Long id;
    private String number;
    private User user;
}
