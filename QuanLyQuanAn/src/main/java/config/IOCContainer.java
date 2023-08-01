package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import controller.RestMonAn;
import model.MonAn;

@Configuration
@ComponentScan(value = "model")
public class IOCContainer {

	@Bean
	public MonAn monAn() {
		return new MonAn(2, "Nguyen Thuy Thuy Trang", 2, true);
	}

}
