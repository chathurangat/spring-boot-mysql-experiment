package com.example.spring.mysql.model.persistent;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

/*    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CategoryContent> categoryContents;*/

}
