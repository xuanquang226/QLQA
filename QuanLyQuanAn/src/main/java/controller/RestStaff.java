package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOStaff;
import model.Staff;

@RestController
public class RestStaff {
	
	@Autowired
	private DAOStaff daoStaff;
	
	@GetMapping(value = "api/staff/{id}")
	public Staff getStaff(@PathVariable long id) {
		return daoStaff.get(id);
	}
}
