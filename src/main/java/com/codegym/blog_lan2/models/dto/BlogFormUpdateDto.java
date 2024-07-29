package com.codegym.blog_lan2.models.dto;

import com.codegym.blog_lan2.models.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BlogFormUpdateDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private MultipartFile avatar;
    private Category category;
}
