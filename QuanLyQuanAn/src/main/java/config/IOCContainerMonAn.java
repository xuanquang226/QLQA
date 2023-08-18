package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import controller.RestMonAn;
import dao.DAOMonAn;
import model.Dish;

@Configuration
@ComponentScan(value = {"model"})
public class IOCContainerMonAn {

   
}
