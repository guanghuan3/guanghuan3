package com.guanghuan3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@MapperScan(basePackages = "com.guanghuan3.customer")
@EnableTransactionManagement
@EnableAutoConfiguration
@ServletComponentScan("com.guanghuan3.web")
@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
