package com.ronaldrogas.ronaldrogasbackend.services.categories;

import com.ronaldrogas.ronaldrogasbackend.entities.categories.SubCategory;

import java.util.List;
import java.util.Optional;

public interface SubCategoryService {

    List<SubCategory> findAll();

    Optional<SubCategory> findById(Long id);

    List<SubCategory> findByCategoryId(Long id);

    SubCategory save(SubCategory subCategory);

    void deleteById(Long id);

}
