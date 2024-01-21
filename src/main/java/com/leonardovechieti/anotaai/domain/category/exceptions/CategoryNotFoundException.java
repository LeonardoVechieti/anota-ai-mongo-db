package com.leonardovechieti.anotaai.domain.category.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String id) {
        super("Category not found with id: " + id);
    }
}
