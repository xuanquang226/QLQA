package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@GetMapping(value = "/aa")
	public String getNameMonAn() {
		return DAOmonAn.get(1).getName();
	}
	
	@PostMapping(value = "/aa")
	public void postMonAn() {
		DAOmonAn.post(monAn);
	}
	
	@PutMapping(value = "/aa")
	public void putMonAn() {
		DAOmonAn.put(monAn, 0);
	}
	
	@DeleteMapping(value = "/aa")
	public void deleteMonAn() {
		DAOmonAn.delete(0);
	}
}
