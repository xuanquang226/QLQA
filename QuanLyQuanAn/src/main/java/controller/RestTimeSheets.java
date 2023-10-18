package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOTimeSheet;
import model.TimeSheets;

@RestController
@ComponentScan({"dao"})
public class RestTimeSheets {

	@Autowired
	private DAOTimeSheet daoTimeSheet;
	
	@GetMapping("/api/timesheets/{id}")
	public TimeSheets getTimeSheets(@PathVariable long id) {
		return daoTimeSheet.get(id); 
	}
}
