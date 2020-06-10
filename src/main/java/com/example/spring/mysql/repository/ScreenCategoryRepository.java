package com.example.spring.mysql.repository;

import com.example.spring.mysql.model.persistent.ScreenCategory;
import com.example.spring.mysql.model.persistent.ScreenCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenCategoryRepository extends JpaRepository<ScreenCategory, ScreenCategoryId> {
}
