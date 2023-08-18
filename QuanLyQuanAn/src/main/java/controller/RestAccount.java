package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOAccount;
import model.Account;

@RestController
@ComponentScan(value = {"dao"})
public class RestAccount {

	@Autowired
	public DAOAccount da;
	
	
	@PostMapping(value = "/api/login")
	public Account getUser(@RequestBody Account a) {
		return da.login(a.getUsername(), a.getPassword());
	} 
	
	
	@PostMapping(value= "/api/account")
	public Account addAccount(@RequestBody Account b) {
		return da.addAccount(b);
	}
}
