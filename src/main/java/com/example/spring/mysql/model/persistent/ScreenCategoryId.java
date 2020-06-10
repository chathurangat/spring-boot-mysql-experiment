package com.example.spring.mysql.model.persistent;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ScreenCategoryId implements Serializable {

    @Column(name = "category")
    private Long categoryId;

    @Column(name = "content")
    private Long contentId;
}
