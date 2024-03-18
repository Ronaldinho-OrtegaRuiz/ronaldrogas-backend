package com.ronaldrogas.ronaldrogasbackend.repositories.categories;

import com.ronaldrogas.ronaldrogasbackend.entities.categories.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>{
}
