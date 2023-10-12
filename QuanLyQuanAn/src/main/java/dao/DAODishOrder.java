package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import model.DishOrder;
import util.HibernateUtil;

@Component
public class DAODishOrder {
	
	
	public List<DishOrder> getListDishOrder(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "from DishOrder";
		List<DishOrder> lDishOrder = ss.createQuery(sql, DishOrder.class).list(); 
		
		tr.commit();
		ss.close();
		
		return lDishOrder;
	}
	
	public List<DishOrder> getListDishOrderWithIdOrder(long idOrder){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "from DishOrder as dishorder where dishorder.id in (select listMA.id from Order as orderr inner join orderr.listMonAn as listMA where orderr.id = :idOrder)";
		List<DishOrder> lDishOrder = ss.createQuery(sql, DishOrder.class).setParameter("idOrder", idOrder).list();
		
		tr.commit();
		ss.close();
		
		return lDishOrder;
	}
	
}
