package com.ronaldrogas.ronaldrogasbackend.entities.sales;

import com.ronaldrogas.ronaldrogasbackend.entities.products.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "details_sales")
public class DetailSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private double subtotal;
}
