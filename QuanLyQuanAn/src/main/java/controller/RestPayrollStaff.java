package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOPayrollStaff;

@RestController
@RequestMapping(value = "/api/payrollstaff")
@ComponentScan(value = {"dao"})
public class RestPayrollStaff {

	@Autowired
	private DAOPayrollStaff daoPayrollStaff;
	
	@PostMapping(value = "/{idPayroll}")
	public void postPayrollStaff(@PathVariable long idPayroll) {
		daoPayrollStaff.postPayrollStaff(idPayroll);
	}
}
