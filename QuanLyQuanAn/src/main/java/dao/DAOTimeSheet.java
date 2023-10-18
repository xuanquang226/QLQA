package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import model.TimeSheets;
import util.HibernateUtil;

@Component
public class DAOTimeSheet implements DAOCRUDInterface<TimeSheets> {

	@Override
	public TimeSheets get(long id) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		TimeSheets timeSheet = ss.get(TimeSheets.class, id);
		
		tr.commit();
		ss.close();
		return timeSheet;
	}

	@Override
	public String put(TimeSheets t, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void post(TimeSheets t) {
		// TODO Auto-generated method stub
		
	}

	
}
