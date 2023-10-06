package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOOrder;
import model.Dish;
import model.Order;

@RestController
@ComponentScan(value = {"dao"})
public class RestOrder {

	@Autowired
	private DAOOrder daoOrder;
	
	@PostMapping("/api/order")
	public void createOrder(@RequestBody Order order, @RequestParam long idStaff, @RequestParam long idTable) {
		daoOrder.createOrder(order, idStaff, idTable);
	}

}
