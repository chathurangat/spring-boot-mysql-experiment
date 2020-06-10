package com.example.spring.mysql.model.persistent;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "screen_category")
public class ScreenCategory implements Serializable {

}
