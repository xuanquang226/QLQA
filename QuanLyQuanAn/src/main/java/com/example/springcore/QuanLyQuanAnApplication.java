package com.example.springcore;


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
import model.DonHang;
import model.HoaDonThanhToan;
import model.KhachHang;
import model.MonAn;
import util.HibernateUtil;


@SpringBootApplication
@ComponentScan(value= "controller")
public class QuanLyQuanAnApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuanLyQuanAnApplication.class, args);
		
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IOCContainer.class);
//		KhachHang kh = (KhachHang) context.getBean(KhachHang.class);
//		kh.setName("Quang");
//		kh.setIdKH(1);
//		
//		MonAn ma1 = (MonAn) context.getBean(MonAn.class);
//		ma1.setId(1);
//		ma1.setName("Bun rieu");
//		ma1.setPrice(15.2f);
//		ma1.setQuantity(1);
//		ma1.setState(true);
//		
//		
//		ArrayList<MonAn> monAns = new ArrayList<MonAn>();
//		monAns.add(ma1)  ;
//		DonHang dh1 = (DonHang) context.getBean(DonHang.class);
//		dh1.setMonAns(monAns);
//		dh1.setIdDH(1);
//		
//		System.out.println(dh1.getMonAns().get(0).getName());
	}

}
