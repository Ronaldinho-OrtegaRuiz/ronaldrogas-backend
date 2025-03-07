package com.ronaldrogas.backend.users.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String street;  // Para guardar "Cra 23 #45"
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private String department;  // Cambiado de state a department
    
    @Column(nullable = false)
    private String country = "Colombia";  // Quitamos el final pero mantenemos el valor por defecto
    
    @Column
    private String reference;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
} 