package com.example.spring.mysql.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Content {
    @JsonIgnore
    protected Long categoryId;
    protected String type;
    protected String title;
    private Long sequenceNo;
    private List<ContentImage> images;
}
