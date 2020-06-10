package com.example.spring.mysql.model.persistent;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "screen_categories")
@IdClass(ScreenCategoryId.class)
public class ScreenCategory implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id", referencedColumnName = "id")
    private Screen screen;

    @Column(name = "sequence_no")
    private Long sequenceNo;
}
