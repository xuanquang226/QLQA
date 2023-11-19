package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOPayrollStaff;
import model.PayrollStaff;

@RestController
@RequestMapping(value = "/api/payrollstaff")
public class RestPayrollStaff {

	@Autowired
	private DAOPayrollStaff daoPayrollStaff;
	
	@PostMapping(value = "/{idPayroll}")
	public void postPayrollStaff(@PathVariable long idPayroll) {
		daoPayrollStaff.postPayrollStaff(idPayroll);
	}
	
	@GetMapping
	public List<PayrollStaff> getListPayrollStaff(@RequestParam long idPayroll){
		return daoPayrollStaff.getListPayrollStaff(idPayroll);
	}
	
}
