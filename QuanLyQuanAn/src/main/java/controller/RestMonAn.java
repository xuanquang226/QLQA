package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import config.IOCContainerMonAn;
import dao.DAOMonAn;
import model.Dish;

@RestController
@ComponentScan(value = {"dao"})
public class RestMonAn {

	@Autowired
	private DAOMonAn DAOmonAn;
		

	@GetMapping(value = "/dish/{id}")
	public Dish getMonAn(@PathVariable long id) {
		return DAOmonAn.get(id);
	}
	
//	@GetMapping(value = "/aa/{id}")
//	public MonAn getMonAn(@PathVariable long id) {
//		return DAOmonAn.get(id);
//	}

	@PostMapping(value = "/dish")
	public void postMonAn(@RequestBody Dish monAn) {
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IOCContainerMonAn.class);
//		monAn = (MonAn) context.getBean("monAn");
		DAOmonAn.post(monAn);
	}

//	@PutMapping(value = "/dish/{id}")	
//	public String putMonAn(@RequestBody Dish monAn, @PathVariable long id) {
////		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IOCContainerMonAn.class);
////		monAn = (MonAn) context.getBean("monAn");
//		return DAOmonAn.put(monAn, id);
//	}

	@DeleteMapping(value = "/dish/{id}")
	public void deleteMonAn(@PathVariable long id) {
		DAOmonAn.delete(id);
	}
	
	@GetMapping(value = "/dish")
	public List<Dish> getListDish(){
		return DAOmonAn.getListDish();
	}
	
	@PutMapping(value = "/dish/{id}")
	public String putNameAQuantityDish(@PathVariable long id,@RequestBody Dish dish) {		
		return DAOmonAn.putNameAQuantity(id, dish);
	}
}
