package com.example.spring.mysql.model.controller;

//import com.example.spring.mysql.model.persistent.Category;

import com.example.spring.mysql.model.persistent.*;
//import com.example.spring.mysql.repository.CategoryRepository;
import com.example.spring.mysql.repository.CategoryContentRepository;
import com.example.spring.mysql.repository.CategoryRepository;
import com.example.spring.mysql.repository.ContentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/screens")
public class Controller {

    private final ContentRepository contentRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryContentRepository categoryContentRepository;

    public Controller(ContentRepository contentRepository,
                      CategoryRepository categoryRepository,
                      CategoryContentRepository categoryContentRepository
    ) {
        this.contentRepository = contentRepository;
        this.categoryRepository = categoryRepository;
        this.categoryContentRepository = categoryContentRepository;
    }

    @GetMapping("/contents")
    private void setContents() {
        Content content = new Content();
        content.setTittle("content 1");
        content.setType("Movie");
        ContentImage contentImage = new ContentImage();
        contentImage.setType("portrait");
        contentImage.setUrl("www.google.lk");
        ContentImage contentImage2 = new ContentImage();
        contentImage2.setType("portrait");
        contentImage2.setUrl("www.google.lk");
        List<ContentImage> imageList = new ArrayList<>();
        imageList.add(contentImage);
        imageList.add(contentImage2);
        content.setContentImages(imageList);
        Content save = contentRepository.save(content);
        System.out.println(save);
    }

    @GetMapping("/categories")
    public void setCategory() {


        Category category = new Category();
        category.setName("Category 1");

        categoryRepository.save(category);
    }

    @GetMapping("/category-contents")
    public void setCategoryContent() {
        CategoryContent categoryContent = new CategoryContent();
        Content content = contentRepository.getOne((long) 1);
        categoryContent.setContent(content);

        Category category = categoryRepository.getOne((long) 4);
        categoryContent.setCategory(category);

        CategoryContentId categoryContentId = new CategoryContentId();
        categoryContentId.setCategoryId(category.getId());
        categoryContentId.setContentId(content.getId());
        categoryContent.setCategoryContentId(categoryContentId);
        categoryContent.setSequenceNo(1);
        CategoryContent save = categoryContentRepository.save(categoryContent);
        System.out.println(save);
    }
}
