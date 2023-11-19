package com.example.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import model.Allowance;


@SpringBootApplication
@ComponentScan(value = {"security", "controller", "config"})
public class QuanLyQuanAnApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuanLyQuanAnApplication.class, args);	
		
	}

}
