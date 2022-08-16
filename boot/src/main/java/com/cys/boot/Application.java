package com.cys.boot;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;

@SpringBootApplication
@MapperScan("com.cys.boot.dao")
@EnableAspectJAutoProxy
public class Application{

	public static void main(String[] args) {
		//
		SpringApplication.run(Application.class, args);
	}
}
