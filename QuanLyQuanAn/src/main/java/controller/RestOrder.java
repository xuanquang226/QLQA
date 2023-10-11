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
	
	@PostMapping(value = "/api/order")
	public long createOrder(@RequestBody Order order, @RequestParam long idStaff, @RequestParam long idTable) {
		return daoOrder.createOrder(order, idStaff, idTable);
	
	}
	
	@GetMapping(value = "/api/order/{id}")
	public Order getOrderById(@PathVariable long id) {
		return daoOrder.get(id);
	}

}
