package com.example.spring.mysql.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Category {

    private Long id;
    private String name;
    private Long sequenceNo;
    private List<Content> contents;
}
