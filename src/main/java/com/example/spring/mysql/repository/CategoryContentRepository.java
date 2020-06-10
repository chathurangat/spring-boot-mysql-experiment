package com.example.spring.mysql.repository;

import com.example.spring.mysql.model.persistent.CategoryContent;
import com.example.spring.mysql.model.persistent.CategoryContentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryContentRepository extends JpaRepository<CategoryContent, CategoryContentId> {
}
