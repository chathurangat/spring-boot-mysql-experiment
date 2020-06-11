package com.example.spring.mysql.repository;

import com.example.spring.mysql.model.persistent.Screen;
import com.example.spring.mysql.model.persistent.ScreenCategory;
import com.example.spring.mysql.model.persistent.ScreenCategoryId;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenCategoryRepository extends JpaRepository<ScreenCategory, ScreenCategoryId> {

    @EntityGraph(attributePaths = "category")
    List<ScreenCategory> findAllByScreen(Screen screen, Sort sort);
}
