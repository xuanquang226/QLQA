package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.MonAn;
import util.HibernateUtil;


@Repository
public class DAOMonAn implements DAOInterface<MonAn> {

	@Override
	public MonAn get(long id) {
		// Create session
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		// Get object on id
		MonAn ma1 = ss.get(MonAn.class, id);
		tr.commit();
		
		// Close session
		ss.close();
		return ma1;
	}

	@Override
	public void put(MonAn t, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void post(MonAn t) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		
	}

}
