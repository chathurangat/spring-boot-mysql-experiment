package com.example.spring.mysql.model.response;

import lombok.Data;

import java.util.List;

@Data
public class HomeScreenResponse {

    private List<HomeScreenData> data;
}
