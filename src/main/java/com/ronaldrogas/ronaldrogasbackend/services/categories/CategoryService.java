package com.ronaldrogas.ronaldrogasbackend.services.categories;

import com.ronaldrogas.ronaldrogasbackend.entities.categories.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    Category save(Category category);

    void deleteById(Long id);
}
