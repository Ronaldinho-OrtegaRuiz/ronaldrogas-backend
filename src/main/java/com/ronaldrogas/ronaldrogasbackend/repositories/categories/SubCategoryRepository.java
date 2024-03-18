package com.ronaldrogas.ronaldrogasbackend.repositories.categories;

import com.ronaldrogas.ronaldrogasbackend.entities.categories.SubCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {

    List<SubCategory> findByCategoryId(Long id);
}
