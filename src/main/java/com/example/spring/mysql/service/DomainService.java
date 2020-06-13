package com.example.spring.mysql.service;

import com.example.spring.mysql.model.persistent.Category;
import com.example.spring.mysql.model.persistent.CategoryContent;
import com.example.spring.mysql.model.persistent.Screen;
import com.example.spring.mysql.model.persistent.ScreenCategory;
import com.example.spring.mysql.repository.CategoryContentRepository;
import com.example.spring.mysql.repository.ScreenCategoryRepository;
import com.example.spring.mysql.repository.ScreenRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainService {

    private final ScreenRepository screenRepository;
    private final CategoryContentRepository categoryContentRepository;
    private final ScreenCategoryRepository screenCategoryRepository;

    public DomainService(ScreenRepository screenRepository,
                         CategoryContentRepository categoryContentRepository,
                         ScreenCategoryRepository screenCategoryRepository) {
        this.screenRepository = screenRepository;
        this.categoryContentRepository = categoryContentRepository;
        this.screenCategoryRepository = screenCategoryRepository;
    }

    @Cacheable(cacheNames = "queryCache", key = "#name")
    public List<Screen> findAllScreens(String name) {
        return screenRepository.findAll();
    }

    @Cacheable(cacheNames = "queryCache", key = "#category.id")
    public List<CategoryContent> getScreenCategoriesByScreen(Category category) {
        return categoryContentRepository.findAllByCategory(category, Sort.by(Sort.Direction.ASC, "sequenceNo"));
    }

    @Cacheable(cacheNames = "queryCache", key = "#screen.id")
    public List<ScreenCategory> getScreenCategories(Screen screen) {
        return screenCategoryRepository.findAllByScreen(screen, Sort.by(Sort.Direction.ASC, "sequenceNo"));
    }
}
