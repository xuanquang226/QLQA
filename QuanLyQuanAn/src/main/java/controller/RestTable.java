package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOTable;
import model.DinnerTable;

@RestController
@ComponentScan(value = {"dao"})
public class RestTable {

	@Autowired
	private DAOTable daoTable;
	
	@GetMapping(value = "/api/table")
	public List<DinnerTable> getTable(){
		return daoTable.getInfoTable();
	}
	
	@GetMapping(value = "/api/table/{id}")
	public DinnerTable getTableById(@PathVariable long id) {
		return daoTable.getTable(id);
	}
	
	@PutMapping(value = "/api/table/{id}")
	public void updateIdOrderForTable(@PathVariable long id, @RequestParam long idOrder) {
		daoTable.updateIdOrderForTable(id, idOrder);
	}
}
