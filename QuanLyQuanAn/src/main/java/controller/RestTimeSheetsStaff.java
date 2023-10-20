package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOTimeSheetsStaff;
import model.TimeSheetsStaff;

@RestController
@RequestMapping(value = "api/timesheetsStaff")
@ComponentScan({"dao"})
public class RestTimeSheetsStaff {
	
	@Autowired
	private DAOTimeSheetsStaff daoTimeSheetsStaff;
	
	@PostMapping
	public void postTimeSheetsStaff(@RequestBody TimeSheetsStaff timeSheetsStaff, @RequestParam long idStaff) {
		daoTimeSheetsStaff.postTimeSheetsStaff(timeSheetsStaff, idStaff);
	}
	
	@GetMapping
	public List<TimeSheetsStaff> getLTimeSheetsStaff(){
		return daoTimeSheetsStaff.getList();
	}
	
	@GetMapping(value = "/count")
	public List<Integer> countTimeSheetsStaff(@RequestParam List<Long> idStaff) {
		return daoTimeSheetsStaff.countTimeSheets(idStaff);
	}
}
