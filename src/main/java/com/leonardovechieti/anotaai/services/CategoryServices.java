package com.leonardovechieti.anotaai.services;

import com.leonardovechieti.anotaai.domain.category.Category;
import com.leonardovechieti.anotaai.domain.category.CategoryDTO;
import com.leonardovechieti.anotaai.domain.category.exceptions.CategoryNotFoundException;
import com.leonardovechieti.anotaai.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {
    private CategoryRepository repository;

    public CategoryServices(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }

    public Category createCategory(CategoryDTO categoryData) {
        Category category = new Category(categoryData);
        this.repository.save(category);
        return category;
    }

    public List<Category> getAll() {
        return this.repository.findAll();
    }

    public Category updateCategory(String id, CategoryDTO categoryData) {
        Category category = this.repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
        if(!categoryData.title().isEmpty())  category.setTitle(categoryData.title());
        if(!categoryData.description().isEmpty())  category.setDescription(categoryData.description());

        this.repository.save(category);
        return category;
    }

    public void deleteCategory(String id) {
        Category category = this.repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
        this.repository.delete(category);
    }

}
