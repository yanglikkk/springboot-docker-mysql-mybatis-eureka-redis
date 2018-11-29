package com.kfit.spring_boot_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Spring Boot启动类.
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2017年1月1日
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCaching
@MapperScan("com.kfit.*")//扫描：该包下相应的class,主要是MyBatis的持久化类.
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
