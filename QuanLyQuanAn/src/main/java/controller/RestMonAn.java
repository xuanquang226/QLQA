package controller;

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
		

	@GetMapping(value = "/aa/{id}")
	public Dish getMonAn(@PathVariable long id) {
		return DAOmonAn.get(id);
	}
	
//	@GetMapping(value = "/aa/{id}")
//	public MonAn getMonAn(@PathVariable long id) {
//		return DAOmonAn.get(id);
//	}

	@PostMapping(value = "/aa/")
	public void postMonAn(@RequestBody Dish monAn) {
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IOCContainerMonAn.class);
//		monAn = (MonAn) context.getBean("monAn");
		DAOmonAn.post(monAn);
	}

	@PutMapping(value = "/aa/{id}")	
	public String putMonAn(@RequestBody Dish monAn, @PathVariable long id) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IOCContainerMonAn.class);
//		monAn = (MonAn) context.getBean("monAn");
		return DAOmonAn.put(monAn, id);
	}

	@DeleteMapping(value = "/aa/{id}")
	public void deleteMonAn(@PathVariable long id) {
		DAOmonAn.delete(id);
	}
	
//	@GetMapping(value = "ab/{id}")
//	public String nameMA() {
//		
//	} 
}
