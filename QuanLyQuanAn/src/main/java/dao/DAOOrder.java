package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import model.Dish;
import model.Order;
import util.HibernateUtil;

@Component
public class DAOOrder implements DAOCRUDInterface<Order> {

	@Override
	public Order get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String put(Order t, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void post(Order t) {
		
	}
	
	public void createOrder(Order order, long idStaff, long idDinnerTable) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
	
		
		ss.save(order);
		String sql = "update Order as o set o.dinnerTable.id = :idDinnerTable, o.staff.idStaff = :idStaff where o.id= :idOrder";
		int result = ss.createQuery(sql).setParameter("idDinnerTable", idDinnerTable).setParameter("idStaff", idStaff).setParameter("idOrder", order.getId()).executeUpdate();
		
		tr.commit();
		ss.close();
	}
//	
	
}
