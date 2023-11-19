package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOPayroll;
import model.Payroll;
import model.PayrollStaff;

@RestController
@RequestMapping(value = "/api/payroll")
public class RestPayroll {
	
	@Autowired
	private DAOPayroll daoPayroll;
	
	@GetMapping("{id}")
	public Payroll get(@PathVariable long id) {
		return daoPayroll.get(id);
	}
	
	@GetMapping("/getprs")
	public PayrollStaff getPRS(@RequestParam(value = "staff") long idStaff, @RequestParam(value = "payroll") long idPayroll) {
		return daoPayroll.getPRS(idStaff, idPayroll);
	}
	
	@PostMapping
	public long postAndGetIDPayroll(@RequestBody Payroll pr) {
		return daoPayroll.postAndGetIDPayroll(pr);
	}
	
	@GetMapping(value = "/getIdPayrollStaff")
	public long queryPayrollAndGetIdPayroll(@RequestParam int month, @RequestParam int year) {
		return daoPayroll.queryPayrollAndGetIdPayroll(month, year);
	}
	
	@GetMapping(value ="/checkPayrollExist")
	public boolean checkPayrollExist(@RequestParam int month, @RequestParam int year) {
		return daoPayroll.checkPayrollExist(month, year);
	}
}
