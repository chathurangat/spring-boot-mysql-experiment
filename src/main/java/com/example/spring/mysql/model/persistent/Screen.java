package com.example.spring.mysql.model.persistent;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "screens")
public class Screen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OrderBy("sequenceNo")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "screen")
    private List<ScreenCategory> screenCategories;
}
