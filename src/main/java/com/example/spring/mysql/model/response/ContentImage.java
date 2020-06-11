package com.example.spring.mysql.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContentImage {
    private String type;
    private String url;
}
