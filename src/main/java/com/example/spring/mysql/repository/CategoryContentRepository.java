package com.example.spring.mysql.repository;

import com.example.spring.mysql.model.persistent.Category;
import com.example.spring.mysql.model.persistent.CategoryContent;
import com.example.spring.mysql.model.persistent.CategoryContentId;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryContentRepository extends JpaRepository<CategoryContent, CategoryContentId> {
    @EntityGraph(attributePaths = "content.contentImages")
    List<CategoryContent> findAllByCategory(Category category, Sort sort);
}
