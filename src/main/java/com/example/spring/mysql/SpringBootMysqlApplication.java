package com.example.spring.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class SpringBootMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqlApplication.class, args);
	}

	@Bean
	public CacheManager cacheManager() {
//		return new ConcurrentMapCacheManager("queryCache");
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		List<Cache> cacheList = new ArrayList<>();
		cacheList.add(new ConcurrentMapCache("queryCache"));
		cacheManager.setCaches(cacheList);
		return cacheManager;
	}
}
