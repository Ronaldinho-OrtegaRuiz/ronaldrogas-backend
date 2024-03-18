package com.ronaldrogas.ronaldrogasbackend.services.categories;

import com.ronaldrogas.ronaldrogasbackend.entities.categories.SubCategory;
import com.ronaldrogas.ronaldrogasbackend.repositories.categories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<SubCategory> findAll() {
        return (List<SubCategory>) subCategoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<SubCategory> findById(Long id) {
        return subCategoryRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SubCategory> findByCategoryId(Long id) {
        return subCategoryRepository.findByCategoryId(id);
    }

    @Transactional
    @Override
    public SubCategory save(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        subCategoryRepository.deleteById(id);
    }
}
