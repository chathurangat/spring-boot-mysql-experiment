package com.example.spring.mysql.model.persistent;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "screen_category")
public class ScreenCategory implements Serializable {

    @EmbeddedId
    private ScreenCategoryId screenCategoryId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Screen screen;
}
