package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import model.DinnerTable;
import util.HibernateUtil;

@Component
public class DAOTable {
	
	public List<DinnerTable> getInfoTable() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "from DinnerTable";
		
		List<DinnerTable> lTable =  ss.createQuery(sql, DinnerTable.class).list();
		tr.commit();
		ss.close();
		
		return lTable;
	}
}
