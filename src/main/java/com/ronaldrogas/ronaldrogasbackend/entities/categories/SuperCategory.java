package com.ronaldrogas.ronaldrogasbackend.entities.categories;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class SuperCategory {
    public String name;
    public String description;
    public Boolean status = true;
}
