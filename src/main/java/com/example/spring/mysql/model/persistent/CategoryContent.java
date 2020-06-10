package com.example.spring.mysql.model.persistent;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "category_contents")
@IdClass(CategoryContentId.class)
public class CategoryContent implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id", referencedColumnName = "id")
    private Content content;

    @Column(name = "sequence_no")
    private Long sequenceNo;
}