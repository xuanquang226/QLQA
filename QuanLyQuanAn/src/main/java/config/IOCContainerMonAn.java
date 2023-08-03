package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import controller.RestMonAn;
import dao.DAOMonAn;
import model.MonAn;

@Configuration
@ComponentScan(value = {"model"})
public class IOCContainerMonAn {
	
//	@Autowired
//	private MonAn monAn;
	
	
	@Bean
	public MonAn monAn() {
		return new MonAn(0, "Hu tieu", 15, true, 50.9f);
	}
	
	@Bean
	public MonAn nameMA() {
		return new MonAn("Com nguoi");
	}
	
	
		

}
