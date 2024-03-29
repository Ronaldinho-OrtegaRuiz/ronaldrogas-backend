package com.ronaldrogas.ronaldrogasbackend.entities.categories;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "sub_categories")
public class SubCategory extends SuperCategory{


    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference
    private Category category;

}
