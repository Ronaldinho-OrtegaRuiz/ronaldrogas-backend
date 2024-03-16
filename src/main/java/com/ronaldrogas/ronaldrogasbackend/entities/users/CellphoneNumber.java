package com.ronaldrogas.ronaldrogasbackend.entities.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cellphone_numbers")
public class CellphoneNumber {
    @Id
    private Long id;
    private String number;

}
