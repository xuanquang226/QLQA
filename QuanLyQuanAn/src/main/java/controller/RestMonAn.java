package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOMonAn;
import model.MonAn;

@RestController
@ComponentScan(value = {"dao", "model"})
public class RestMonAn {
	
	@Autowired
	private DAOMonAn DAOmonAn;
	
	@Autowired
	private MonAn monAn; 
	
	
	@GetMapping(value = "/aa/{id}")
	public String getNameMonAn(@PathVariable long id) {
		return DAOmonAn.get(id).getName();
	}
	
	@PostMapping(value = "/aa")
	public void postMonAn() {
		// Temp data for test function
		monAn.setName("Bun dau");
		monAn.setPrice(15.000F);
		monAn.setQuantity(10);
		monAn.setState(true);
		
		
		DAOmonAn.post(monAn);
	}
	
	@PutMapping(value = "/aa/{id}")
	public void putMonAn(@PathVariable long id) {
		DAOmonAn.put(monAn, id);
	}
	
	@DeleteMapping(value = "/aa")
	public void deleteMonAn() {
		DAOmonAn.delete(0);
	}
}
