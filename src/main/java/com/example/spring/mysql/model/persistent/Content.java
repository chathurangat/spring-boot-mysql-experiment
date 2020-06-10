package com.example.spring.mysql.model.persistent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@Entity
//@Table(name = "Contens")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Content implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    private String tittle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contentImages",referencedColumnName = "id",nullable = false,foreignKey = @ForeignKey)
    private List<ContentImage> contentImages;

/*    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CategoryContent> categoryContents;*/

}
