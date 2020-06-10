package com.example.spring.mysql.model.persistent;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "contents")
public class Content implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String type;
    private String tittle;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "content")
    private List<ContentImage> contentImages;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "content")
    private List<CategoryContent> categoryContents;
}
