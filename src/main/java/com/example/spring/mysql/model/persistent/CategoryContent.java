package com.example.spring.mysql.model.persistent;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "CategoryContent")
@Table(name = "category_content")
public class CategoryContent implements Serializable {

    @EmbeddedId
    private CategoryContentId categoryContentId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    private Content content;
    private Integer sequenceNo;

/*    public CategoryContent() {
    }

    public CategoryContent(Category category, Content content) {
        this.category = category;
        this.content = content;
    }*/
}
