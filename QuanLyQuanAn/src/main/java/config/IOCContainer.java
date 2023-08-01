package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import controller.RestMonAn;
import model.MonAn;

@Configuration
@ComponentScan(value="model")
public class IOCContainer {

	@Bean
	public MonAn monAn() {
		return new MonAn(1,"AAA",2, true, 4.0F);
	}
		
}
