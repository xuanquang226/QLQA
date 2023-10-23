package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOTimeSheet;
import model.TimeSheets;

@RestController
@ComponentScan({"dao"})
@RequestMapping("/api/timesheets")
public class RestTimeSheets {

	@Autowired
	private DAOTimeSheet daoTimeSheet;
	
	@GetMapping("/{id}")
	public TimeSheets getTimeSheets(@PathVariable long id) {
		return daoTimeSheet.get(id); 
	}
	
	@PostMapping
	public void postTimeSheets(@RequestBody TimeSheets timesheet) {
		daoTimeSheet.post(timesheet);
	}
	
	@PostMapping("/getid")
	public long postAndGetId(@RequestBody TimeSheets timeSheets) {
		return daoTimeSheet.postAndGetID(timeSheets);
	}
	
	@GetMapping("/date")
	public TimeSheets getTimeSheetsWithDate() {
		return daoTimeSheet.getTimeSheetsWithDate();
	}
	
}
