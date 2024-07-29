package com.codegym.blog_lan2.services.category;


import com.codegym.blog_lan2.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Iterable<Category> findAll();

    Page<Category> findAll(String name, Pageable pageable);

    Category findById(Long id);

    void save(Category category);

    void deleteById(Long id);
}