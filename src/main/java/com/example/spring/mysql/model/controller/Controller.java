//package com.example.spring.mysql.model.controller;
//
////import com.example.spring.mysql.model.persistent.Category;
//
//import com.example.spring.mysql.model.persistent.*;
////import com.example.spring.mysql.repository.CategoryRepository;
//import com.example.spring.mysql.repository.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/screens")
//public class Controller {
//
//    private final ContentRepository contentRepository;
//    private final CategoryRepository categoryRepository;
//    private final CategoryContentRepository categoryContentRepository;
//    private final ScreenRepository screenRepository;
//    private final ScreenCategoryRepository screenCategoryRepository;
//
//    public Controller(ContentRepository contentRepository,
//                      CategoryRepository categoryRepository,
//                      CategoryContentRepository categoryContentRepository,
//                      ScreenRepository screenRepository,
//                      ScreenCategoryRepository screenCategoryRepository
//    ) {
//        this.contentRepository = contentRepository;
//        this.categoryRepository = categoryRepository;
//        this.categoryContentRepository = categoryContentRepository;
//        this.screenRepository = screenRepository;
//        this.screenCategoryRepository = screenCategoryRepository;
//    }
//
//    @GetMapping("/contents")
//    private void setContents() {
//        Content content = new Content();
//        content.setTittle("content 1");
//        content.setType("Movie");
//        ContentImage contentImage = new ContentImage();
//        contentImage.setType("portrait");
//        contentImage.setUrl("www.google.lk");
//        ContentImage contentImage2 = new ContentImage();
//        contentImage2.setType("portrait");
//        contentImage2.setUrl("www.google.lk");
//        List<ContentImage> imageList = new ArrayList<>();
//        imageList.add(contentImage);
//        imageList.add(contentImage2);
//        content.setContentImages(imageList);
//        Content save = contentRepository.save(content);
//        System.out.println(save);
//    }
//
//    @GetMapping("/categories")
//    public void setCategory() {
//
//
//        Category category = new Category();
//        category.setName("Category 1");
//
//        categoryRepository.save(category);
//    }
//
//    @GetMapping("/category-contents")
//    public void setCategoryContent() {
//        CategoryContent categoryContent = new CategoryContent();
//        Content content = contentRepository.getOne((long) 1);
//        categoryContent.setContent(content);
//
//        Category category = categoryRepository.getOne((long) 4);
//        categoryContent.setCategory(category);
//
//        CategoryContentId categoryContentId = new CategoryContentId();
//        categoryContentId.setCategoryId(category.getId());
//        categoryContentId.setContentId(content.getId());
//        categoryContent.setCategoryContentId(categoryContentId);
//        categoryContent.setSequenceNo(1);
//        CategoryContent save = categoryContentRepository.save(categoryContent);
//        System.out.println(save);
//    }
//
//    @GetMapping("/screens")
//    public void setScreen() {
//        Screen screen = new Screen();
//        screen.setName("Home");
//        Screen save = screenRepository.save(screen);
//        System.out.println(save);
//    }
//
//    @GetMapping("/screen-categories")
//    public void setScreenCategory() {
//        ScreenCategory screenCategory = new ScreenCategory();
//        Screen screen = screenRepository.getOne((long) 5);
//        screenCategory.setScreen(screen);
//
//        Category category = categoryRepository.getOne((long) 4);
//        screenCategory.setCategory(category);
//
//        ScreenCategoryId screenCategoryId = new ScreenCategoryId();
//        screenCategoryId.setCategoryId(category.getId());
//        screenCategoryId.setScreenId(screen.getId());
//        screenCategory.setScreenCategoryId(screenCategoryId);
//
//        ScreenCategory save = screenCategoryRepository.save(screenCategory);
//        System.out.println(save);
//
//    }
//}
