package com.codegym.blog_lan2.controllers.api;

import com.codegym.blog_lan2.models.Blog;
import com.codegym.blog_lan2.services.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogApiController {

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "5") int size) {
        Page<Blog> blogPage = blogService.findAll(PageRequest.of(page, size, Sort.by("title").descending()));
        return ResponseEntity.ok(blogPage.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(blog);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Blog>> getBlogsByCategoryId(@PathVariable int categoryId,
                                                           @RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "5") int size) {
        Page<Blog> blogPage = blogService.findAllBlogByCategoryId(categoryId, PageRequest.of(page, size, Sort.by("title").descending()));
        return ResponseEntity.ok(blogPage.getContent());
    }
}
