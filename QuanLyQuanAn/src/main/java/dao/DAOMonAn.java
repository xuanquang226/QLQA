package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.Dish;
import util.HibernateUtil;


@Component
public class DAOMonAn implements DAOCRUDInterface<Dish> {
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();
	@Override
	public Dish get(long id) {
		// Create session
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		// Get object on id
		Dish ma1 = ss.get(Dish.class, id);
		tr.commit();
		
		// Close session
		ss.close();
		return ma1;
	}

	@Override
	public String put(Dish ma1, long id) {
		Session ss =  sf.openSession();
		Transaction tr = ss.beginTransaction();
		
//		// Get object on id
//		Dish ma2 = ss.get(Dish.class, id);
//		
//		// Transaction status
//		ss.evict(ma2);
//		
//		if(ma1.getName() != null) {
//			ma2.setName(ma1.getName());
//		}
//		if(ma1.getPrice() != 0) {
//			ma2.setPrice(ma1.getPrice());
//		}
//		
//		if(ma1.getQuantity() != 0) {
//			ma2.setQuantity(ma1.getQuantity());
//		}
//		
//		if(ma1.getState() != true) {
//			ma2.setState(ma1.getState());
//		}
//		// Persist object
//		ss.merge(ma2);
		
		String sql = "update Dish set name = :newName, price = :newPrice, quantity = :newQuantity where id = :id ";
		
		int result = ss.createQuery(sql).setParameter("newName", ma1.getName())
														.setParameter("newPrice", ma1.getPrice())
														.setParameter("newQuantity", ma1.getQuantity())
														.setParameter("id", id)
														.executeUpdate();
													
		
		tr.commit();
		ss.close();
		return "Thay doi "+ result +" mon";
	}

	@Override
	public void delete(long id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Dish ma = ss.get(Dish.class, id);
		ss.remove(ma);
		
		tr.commit();
		ss.close();		
	}

	@Override
	public void post(Dish t) {
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
	
	public List<Dish> getListDish() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "From Dish order by name asc";
		List<Dish> lDish = ss.createQuery(sql, Dish.class).list();
		
		tr.commit();
		ss.close();
		return lDish;
	}
	
	public String putNameAQuantity(long id, Dish dish ) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "update Dish set name = :newName, quantity = :newQuantity, price =: newPrice where id = :id";
		int result = ss.createQuery(sql).setParameter("newName", dish.getName())
										.setParameter("newQuantity", dish.getQuantity())
										.setParameter("id", dish.getId())
										.setParameter("newPrice", dish.getPrice()).executeUpdate();
		
		tr.commit();
		ss.close();
		return "Thay doi";
	}
}
