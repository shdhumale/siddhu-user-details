package com.siddhugraphql.java.siddhuuserdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.siddhugraphql.java.siddhuuserdetails"})
public class SiddhuUserDetailsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SiddhuUserDetailsApplication.class, args);
	}
	
}
