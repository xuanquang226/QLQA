package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import config.IOCContainerMonAn;
import dao.DAOMonAn;
import model.MonAn;

@RestController
@ComponentScan(value = {"dao"})
public class RestMonAn {

	@Autowired
	private DAOMonAn DAOmonAn;
	

	@GetMapping(value = "/aa/{id}")
	public String getNameMonAn(@PathVariable long id) {
		return DAOmonAn.get(id).getName();
	}

	@PostMapping(value = "/aa/")
	public void postMonAn() {
		// Temp data for test function
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IOCContainerMonAn.class);
		MonAn monAn = (MonAn) context.getBean("monAn");
		DAOmonAn.post(monAn);
	}

	@PutMapping(value = "/aa/{id}")
	public void putNameMonAn(@PathVariable long id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IOCContainerMonAn.class);
		MonAn monAn = (MonAn) context.getBean("nameMA");		
		DAOmonAn.put(monAn, id);
	}

	@DeleteMapping(value = "/aa/{id}")
	public void deleteMonAn(@PathVariable long id) {
		DAOmonAn.delete(id);
	}
}
