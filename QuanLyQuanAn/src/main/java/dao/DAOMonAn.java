package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.MonAn;
import util.HibernateUtil;


@Component
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
	public void put(MonAn ma1, long id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss =  sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		// Get object on id
		MonAn ma2 = ss.get(MonAn.class, id);
		
		// Transaction status
		ss.evict(ma2);
		
		if(ma1.getName() != null) {
			ma2.setName(ma1.getName());
		}
		if(ma1.getPrice() != 0) {
			ma2.setPrice(ma1.getPrice());
		}
		
		if(ma1.getQuantity() != 0) {
			ma2.setQuantity(ma1.getQuantity());
		}
		
		if(ma1.getState() != true) {
			ma2.setState(ma1.getState());
		}
		// Persist object
		ss.merge(ma2);
		
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
		
		//Temp data
//		t.setName("Dau hu don thit");
//		t.setPrice(15.5f);
//		t.setQuantity(10);
//		t.setState(true);
		
		ss.persist(t);
		
		tr.commit();
		ss.close();
	}
}
