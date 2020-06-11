package com.example.spring.mysql.transformer;

import com.example.spring.mysql.model.persistent.CategoryContent;
import com.example.spring.mysql.model.persistent.Screen;
import com.example.spring.mysql.model.response.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ScreenResponseGenerator {

    public HomeScreenResponse generate(List<Screen> screens, List<CategoryContent> categoryContents, Long screenId) {
        HomeScreenResponse homeScreenResponse = new HomeScreenResponse();
        List<HomeScreenData> screenData = screens.parallelStream().map(screen ->
                HomeScreenData.builder()
                        .id(screen.getId())
                        .name(screen.getName())
                        .build()
        ).collect(Collectors.toList());

        Screen activeScreen = screens.parallelStream().filter(screen -> screen.getId().equals(screenId)).findFirst().get();

        Map<Long, List<Content>> contentsMap = categoryContents.parallelStream().
                map(categoryContent ->
                        Content.builder()
                                .categoryId(categoryContent.getCategory().getId())
                                .type(categoryContent.getContent().getType())
                                .sequenceNo(categoryContent.getSequenceNo())
                                .title(categoryContent.getContent().getName())
                                .images(categoryContent.getContent().getContentImages()
                                        .parallelStream().map(contentImage -> ContentImage.builder()
                                                .type(contentImage.getType())
                                                .url(contentImage.getUrl())
                                                .build()
                                        ).collect(Collectors.toList())
                                ).build())
                .collect(Collectors.groupingBy(Content::getCategoryId));

        List<Category> categories = activeScreen.getScreenCategories()
                .parallelStream()
                .map(screenCategory -> Category.builder()
                        .id(screenCategory.getCategory().getId())
                        .name(screenCategory.getCategory().getName())
                        .sequenceNo(screenCategory.getSequenceNo())
                        .contents(contentsMap.get(screenCategory.getCategory().getId()))
                        .build())
                .collect(Collectors.toList());

        HomeScreenData homeScreenData1 = screenData.parallelStream()
                .filter(homeScreenData -> homeScreenData.getId().equals(screenId))
                .findFirst()
                .get();

        homeScreenData1.setCategories(categories);
        homeScreenResponse.setData(screenData);
        return homeScreenResponse;
    }


    public HomeScreenResponse generate2(List<Screen> screens, List<CategoryContent> categoryContents, Long screenId) {
        HomeScreenResponse homeScreenResponse = new HomeScreenResponse();
        List<HomeScreenData> screenData = screens.stream().map(screen ->
                HomeScreenData.builder()
                        .id(screen.getId())
                        .name(screen.getName())
                        .build()
        ).collect(Collectors.toList());

        Screen activeScreen = screens.stream()
                .filter(screen -> screen.getId().equals(screenId)).findFirst().get();

        Map<Long, List<Content>> contentsMap = categoryContents.stream().
                map(categoryContent ->
                        Content.builder()
                                .categoryId(categoryContent.getCategory().getId())
                                .type(categoryContent.getContent().getType())
                                .sequenceNo(categoryContent.getSequenceNo())
                                .title(categoryContent.getContent().getName())
                                .images(categoryContent.getContent().getContentImages()
                                        .stream().map(contentImage -> ContentImage.builder()
                                                .type(contentImage.getType())
                                                .url(contentImage.getUrl())
                                                .build()
                                        ).collect(Collectors.toList())
                                ).build())
                .collect(Collectors.groupingBy(Content::getCategoryId));

        List<Category> categories = activeScreen.getScreenCategories()
                .stream()
                .map(screenCategory -> Category.builder()
                        .id(screenCategory.getCategory().getId())
                        .name(screenCategory.getCategory().getName())
                        .sequenceNo(screenCategory.getSequenceNo())
                        .contents(contentsMap.get(screenCategory.getCategory().getId()))
                        .build())
                .collect(Collectors.toList());

        HomeScreenData homeScreenData1 = screenData.stream()
                .filter(homeScreenData -> homeScreenData.getId().equals(screenId))
                .findFirst()
                .get();

        homeScreenData1.setCategories(categories);
        homeScreenResponse.setData(screenData);
        return homeScreenResponse;
    }


    public HomeScreenResponse generate3(List<Screen> screens, List<CategoryContent> categoryContents, Long screenId) {
        HomeScreenResponse homeScreenResponse = new HomeScreenResponse();
        List<HomeScreenData> screenData = screens.parallelStream().map(screen ->
                HomeScreenData.builder()
                        .id(screen.getId())
                        .name(screen.getName())
                        .build()
        ).collect(Collectors.toList());

        Screen activeScreen = screens.stream()
                .filter(screen -> screen.getId().equals(screenId)).findFirst().get();

        Map<Long, List<Content>> contentsMap = categoryContents.parallelStream().
                map(categoryContent ->
                        Content.builder()
                                .categoryId(categoryContent.getCategory().getId())
                                .type(categoryContent.getContent().getType())
                                .sequenceNo(categoryContent.getSequenceNo())
                                .title(categoryContent.getContent().getName())
                                .images(categoryContent.getContent().getContentImages()
                                        .stream().map(contentImage -> ContentImage.builder()
                                                .type(contentImage.getType())
                                                .url(contentImage.getUrl())
                                                .build()
                                        ).collect(Collectors.toList())
                                ).build())
                .collect(Collectors.groupingBy(Content::getCategoryId));

        List<Category> categories = activeScreen.getScreenCategories()
                .stream()
                .map(screenCategory -> Category.builder()
                        .id(screenCategory.getCategory().getId())
                        .name(screenCategory.getCategory().getName())
                        .sequenceNo(screenCategory.getSequenceNo())
                        .contents(contentsMap.get(screenCategory.getCategory().getId()))
                        .build())
                .collect(Collectors.toList());

        HomeScreenData homeScreenData1 = screenData.stream()
                .filter(homeScreenData -> homeScreenData.getId().equals(screenId))
                .findFirst()
                .get();

        homeScreenData1.setCategories(categories);
        homeScreenResponse.setData(screenData);
        return homeScreenResponse;
    }
}
