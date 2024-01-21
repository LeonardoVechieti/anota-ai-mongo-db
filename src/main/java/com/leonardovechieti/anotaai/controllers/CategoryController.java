package com.leonardovechieti.anotaai.controllers;

import com.leonardovechieti.anotaai.domain.category.Category;
import com.leonardovechieti.anotaai.domain.category.CategoryDTO;
import com.leonardovechieti.anotaai.services.CategoryServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryServices service;

    public CategoryController(CategoryServices services) {
        this.service = services;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryData) {
        Category newCategory = this.service.createCategory(categoryData);
        return ResponseEntity.ok().body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = this.service.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable String id, @RequestBody CategoryDTO categoryData) {
        Category newCategory = this.service.updateCategory(id, categoryData);
        return ResponseEntity.ok().body(newCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String id) {
        this.service.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
