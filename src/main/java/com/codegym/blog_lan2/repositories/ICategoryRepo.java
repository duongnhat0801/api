package com.codegym.blog_lan2.repositories;

import com.codegym.blog_lan2.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends JpaRepository<Category,Long> {
    Page<Category> findAllByNameContaining(String name, Pageable pageable);
}
