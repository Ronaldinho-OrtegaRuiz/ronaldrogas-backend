package com.ronaldrogas.ronaldrogasbackend.controllers;

import com.ronaldrogas.ronaldrogasbackend.entities.categories.Category;
import com.ronaldrogas.ronaldrogasbackend.entities.categories.SubCategory;
import com.ronaldrogas.ronaldrogasbackend.services.categories.CategoryService;
import com.ronaldrogas.ronaldrogasbackend.services.categories.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/subcategories")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> listAllSubCategories() {
        List<SubCategory> subCategories = subCategoryService.findAll();
        if (subCategories.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(subCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewSubCategory(@PathVariable Long id) {
        Optional<SubCategory> subCategoryOptional = subCategoryService.findById(id);
        if (subCategoryOptional.isPresent()) {
            return ResponseEntity.ok(subCategoryOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/bycategory/{id}")
    public ResponseEntity<?> listSubCategoriesByCategory(@PathVariable Long id) {
        List<SubCategory> subCategories = subCategoryService.findByCategoryId(id);
        if (subCategories.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(subCategories);
    }

    @PostMapping
    public ResponseEntity<?> createSubCategory(@RequestBody SubCategory subCategory) {
        Category category = subCategory.getCategory();
        if (category != null) {
            Optional<Category> categoryOptional = categoryService.findById(category.getId());
            if (categoryOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryService.save(subCategory));
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubCategory(@PathVariable Long id, @RequestBody SubCategory subCategory) {
        Optional<SubCategory> subCategoryOptional = subCategoryService.findById(id);
        if (subCategoryOptional.isPresent()) {
            subCategory.setId(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryService.save(subCategory));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubCategory(@PathVariable Long id) {
        Optional<SubCategory> subCategoryOptional = subCategoryService.findById(id);
        if (subCategoryOptional.isPresent()) {
            subCategoryService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
