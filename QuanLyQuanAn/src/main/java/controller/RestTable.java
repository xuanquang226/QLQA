package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOTable;
import model.DinnerTable;

@RestController
@ComponentScan(value = {"dao"})
public class RestTable {

	@Autowired
	private DAOTable daoTable;
	
	
	@GetMapping(value = "api/table")
	public List<DinnerTable> getTable(){
		return daoTable.getInfoTable();
	}
}
