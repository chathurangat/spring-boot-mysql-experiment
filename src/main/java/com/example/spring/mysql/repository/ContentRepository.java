package com.example.spring.mysql.repository;

import com.example.spring.mysql.model.persistent.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content,Long> {
}
