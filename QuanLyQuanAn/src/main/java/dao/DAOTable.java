package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import model.Table;
import util.HibernateUtil;

@Component
public class DAOTable {
	
	public List<Table> getInfoTable() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "from Table";
		
		List<Table> lTable =  ss.createQuery(sql, Table.class).list();
		tr.commit();
		ss.close();
		
		return lTable;
	}
}
