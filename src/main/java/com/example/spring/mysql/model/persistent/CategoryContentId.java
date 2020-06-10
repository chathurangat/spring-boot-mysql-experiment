package com.example.spring.mysql.model.persistent;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Data
@Embeddable
public class CategoryContentId implements Serializable {

    @Column(name = "category")
    private Long categoryId;

    @Column(name = "content")
    private Long contentId;

/*
    public CategoryContentId() {

    }

    public CategoryContentId(Long categoryId, Long contentId) {
        this.categoryId = categoryId;
        this.contentId = contentId;
    }
*/

}
