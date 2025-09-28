package com.design.communityManagementSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.design.communityManagementSystem.mapper")
@ComponentScan(value="com.design")
public class CommunityManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityManagementSystemApplication.class, args);
	}

}
