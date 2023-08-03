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
public class DAOMonAn implements DAOCRUDInterface<MonAn> {

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
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss =  sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		// Get object on id
		t = ss.get(MonAn.class, id);
		
		// Transaction status
		ss.evict(t);
		
		
		// Temp data for test function
		// Set new value for object
		t.setName("Banh xeo");
		t.setPrice(18.0f);
		
		// Persist object
		ss.merge(t);
		
		tr.commit();
		ss.close();
		
	}

	@Override
	public void delete(long id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		MonAn ma = ss.get(MonAn.class, id);
		ss.remove(ma);
		
		tr.commit();
		ss.close();		
	}

	@Override
	public void post(MonAn t) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss =  sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		ss.save(t);
		
		tr.commit();
		ss.close();
	}
}
