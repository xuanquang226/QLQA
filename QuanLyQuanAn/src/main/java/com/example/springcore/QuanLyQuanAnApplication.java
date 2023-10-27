package com.example.springcore;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import config.IOCContainerMonAn;
import controller.RestMonAn;
import model.Order;
import model.Account;
import model.HoaDonThanhToan;
import model.Guest;
import model.Dish;
import util.HibernateUtil;


@SpringBootApplication
@ComponentScan(value= "controller")
public class QuanLyQuanAnApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuanLyQuanAnApplication.class, args);	
		
	}

}
