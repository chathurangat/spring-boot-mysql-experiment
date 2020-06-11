package com.example.spring.mysql.service;

import com.example.spring.mysql.model.persistent.Category;
import com.example.spring.mysql.model.persistent.CategoryContent;
import com.example.spring.mysql.model.persistent.Screen;
import com.example.spring.mysql.repository.CategoryContentRepository;
import com.example.spring.mysql.repository.ScreenRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainService {

    private final ScreenRepository screenRepository;
    private final CategoryContentRepository categoryContentRepository;

    public DomainService(ScreenRepository screenRepository, CategoryContentRepository categoryContentRepository) {
        this.screenRepository = screenRepository;
        this.categoryContentRepository = categoryContentRepository;
    }

    @Cacheable(cacheNames = "queryCache", key = "#name")
    public List<Screen> findAllScreens(String name) {
        System.out.println("============accesss from database");
        return screenRepository.findAll();
    }

    @Cacheable(cacheNames = "queryCache", key = "#category.id")
    public List<CategoryContent> getScreenCategoriesByScreen(Category category) {
        return categoryContentRepository.findAllByCategory(category, Sort.by(Sort.Direction.ASC, "sequenceNo"));
    }
}
