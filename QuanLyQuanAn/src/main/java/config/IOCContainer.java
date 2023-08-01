package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import controller.RestMonAn;
import model.MonAn;

@Configuration
@ComponentScan(value = "model")
public class IOCContainer {

}
