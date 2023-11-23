package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.text.DateFormatter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.Dish;
import model.Order;
import util.HibernateUtil;

@Component
public class DAOOrder implements DAOCRUDInterface<Order> {
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Override
	public Order get(long id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Order order = ss.get(Order.class, id);
		tr.commit();
		ss.close();
		return order;
	}

	@Override
	public String put(Order t, long id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		ss.update(t);
		tr.commit();
		ss.close();
		return "Thanh toan thanh cong";
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void post(Order t) {
		
	}
	
	public long createOrder(Order order, long idStaff, long idDinnerTable) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.saveOrUpdate(order);
		
		String sql = "update Order as o set o.dinnerTable.id = :idDinnerTable, o.staff.idStaff = :idStaff where o.id= :idOrder";		
		int result = ss.createQuery(sql).setParameter("idDinnerTable", idDinnerTable).setParameter("idStaff", idStaff).setParameter("idOrder", order.getId()).executeUpdate();
		
		long idOrder = order.getId();
		tr.commit();
		ss.close();
		return idOrder;
	}
//	
	
}
