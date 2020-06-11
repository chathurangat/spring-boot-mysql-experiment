package com.example.spring.mysql.model.controller;

import com.example.spring.mysql.model.persistent.Category;

import com.example.spring.mysql.model.persistent.*;
import com.example.spring.mysql.model.response.HomeScreenResponse;
import com.example.spring.mysql.repository.*;
import com.example.spring.mysql.transformer.ScreenResponseGenerator;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/screens")
public class Controller {

    private final ContentRepository contentRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryContentRepository categoryContentRepository;
    private final ScreenRepository screenRepository;
    private final ScreenCategoryRepository screenCategoryRepository;
    private final ScreenResponseGenerator screenResponseGenerator;

    public Controller(ContentRepository contentRepository,
                      CategoryRepository categoryRepository,
                      CategoryContentRepository categoryContentRepository,
                      ScreenRepository screenRepository,
                      ScreenCategoryRepository screenCategoryRepository,
                      ScreenResponseGenerator screenResponseGenerator) {
        this.contentRepository = contentRepository;
        this.categoryRepository = categoryRepository;
        this.categoryContentRepository = categoryContentRepository;
        this.screenRepository = screenRepository;
        this.screenCategoryRepository = screenCategoryRepository;
        this.screenResponseGenerator = screenResponseGenerator;
    }

    @GetMapping("/contents")
    private void setContents() {
        for (int i = 1; i < 20; i++) {


            Content content = new Content();
            content.setTittle("content " + i);
            content.setType("Movie");
            ContentImage contentImage = new ContentImage();
            contentImage.setType("portrait");
            contentImage.setUrl("www.google.lk");
            contentImage.setContent(content);
            ContentImage contentImage2 = new ContentImage();
            contentImage2.setType("portrait");
            contentImage2.setUrl("www.google.lk");
            contentImage2.setContent(content);
            List<ContentImage> imageList = new ArrayList<>();
            imageList.add(contentImage);
            imageList.add(contentImage2);
            content.setContentImages(imageList);
            contentRepository.save(content);
        }
    }

    @GetMapping("/categories")
    public void setCategory() {

        for (int i = 1; i < 20; i++) {
            Category category = new Category();
            category.setName("Category " + i);

            categoryRepository.save(category);
        }
    }

    @GetMapping("/category-contents")
    public void setCategoryContent() {

        CategoryContent categoryContent = new CategoryContent();
        Content content = contentRepository.getOne((long) 33);
        categoryContent.setContent(content);

        Category category = categoryRepository.getOne((long) 65);
        categoryContent.setCategory(category);

        categoryContent.setCategory(category);
        categoryContent.setContent(content);
        categoryContent.setSequenceNo((long) 3);
        categoryContentRepository.save(categoryContent);
    }

    @GetMapping("/screens")
    public void setScreen() {
        Screen screen = new Screen();
        screen.setName("Home");
        screenRepository.save(screen);
    }

    @GetMapping("/screen-categories")
    public void setScreenCategory() {
        ScreenCategory screenCategory = new ScreenCategory();
        Screen screen = screenRepository.getOne((long) 5);
        screenCategory.setScreen(screen);

        Category category = categoryRepository.getOne((long) 65);
        screenCategory.setCategory(category);
        screenCategory.setScreen(screen);
        screenCategory.setSequenceNo((long) 2);

        screenCategoryRepository.save(screenCategory);

    }

    @GetMapping("/home-screens")
    public HomeScreenResponse getHomeScreen() {

        List<Screen> screens = screenRepository.findAll();
        Screen homeScreen = screens.parallelStream().filter(screen -> screen.getName().equals("Home")).findFirst().get();
        List<ScreenCategory> screenCategories = screenCategoryRepository.findAllByScreen(homeScreen, Sort.by(Sort.Direction.ASC, "sequenceNo"));
        List<Category> categories = screenCategories.parallelStream().map(ScreenCategory::getCategory).collect(Collectors.toList());
        List<CategoryContent> categoryContents = new ArrayList<>();

        categories.parallelStream().map(category ->
                categoryContentRepository.findAllByCategory(category, Sort.by(Sort.Direction.ASC, "sequenceNo"))
        ).forEachOrdered(categoryContents::addAll);
        return screenResponseGenerator.generate(screens, categoryContents, homeScreen.getId());
    }

    @GetMapping("/home-screens2")
    public HomeScreenResponse getHomeScreenWithoutParallelStream() {

        List<Screen> screens = screenRepository.findAll();
        Screen homeScreen = screens.parallelStream().filter(screen -> screen.getName().equals("Home")).findFirst().get();
        List<ScreenCategory> screenCategories = screenCategoryRepository.findAllByScreen(homeScreen, Sort.by(Sort.Direction.ASC, "sequenceNo"));
        List<Category> categories = screenCategories.parallelStream().map(ScreenCategory::getCategory).collect(Collectors.toList());
        List<CategoryContent> categoryContents = new ArrayList<>();

        categories.stream().map(category ->
                categoryContentRepository.findAllByCategory(category, Sort.by(Sort.Direction.ASC, "sequenceNo"))
        ).forEachOrdered(categoryContents::addAll);
        return screenResponseGenerator.generate(screens, categoryContents, homeScreen.getId());
    }
}
