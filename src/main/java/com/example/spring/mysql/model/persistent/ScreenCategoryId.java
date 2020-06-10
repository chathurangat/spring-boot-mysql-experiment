package com.example.spring.mysql.model.persistent;

import lombok.Data;
import java.io.Serializable;

@Data
public class ScreenCategoryId implements Serializable
{
    private Long category;
    private Long screen;
}