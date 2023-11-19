package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.DAODishOrder;
import model.DishOrder;

@RestController
public class RestDishOrder {

	@Autowired
	private DAODishOrder daoDishOrder;
	
	@GetMapping("/api/dishorder")
	public List<DishOrder> getListDishOrder(){
		return daoDishOrder.getListDishOrder();
	}
	
	@GetMapping("/api/dishorder/{idOrder}")
	public List<DishOrder> getListDishOrderWithIdOrder(@PathVariable long idOrder){
		return daoDishOrder.getListDishOrderWithIdOrder(idOrder);
	}
	
}
