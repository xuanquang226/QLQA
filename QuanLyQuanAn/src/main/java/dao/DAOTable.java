package dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.DinnerTable;
import util.HibernateUtil;

@Repository
public class DAOTable {
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public List<DinnerTable> getInfoTable() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "from DinnerTable";
		
		List<DinnerTable> lTable =  ss.createQuery(sql, DinnerTable.class).list();
		tr.commit();
		ss.close();
		
		return lTable;
	}
	
	public void updateIdOrderForTable(long idTable, long idOrder) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "update DinnerTable set idOrder = :idOrder where id = :idTable";
		int result = ss.createQuery(sql).setParameter("idOrder", idOrder).setParameter("idTable", idTable).executeUpdate();
		tr.commit();
		ss.close();
	}
	
	public DinnerTable getTable(long idTable) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		DinnerTable dinnerTable = ss.get(DinnerTable.class, idTable);
		tr.commit();
		ss.close();
		
		return dinnerTable;
	}
}
