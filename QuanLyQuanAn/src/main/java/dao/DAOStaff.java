package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.Account;
import model.Staff;
import util.HibernateUtil;


@Component
public class DAOStaff implements DAOCRUDInterface<Staff> {
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Override
	public Staff get(long idAccount) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String sql = "from Staff as s where s.account.id = : idAccount";
		Staff s1 = ss.createQuery(sql, Staff.class).setParameter("idAccount", idAccount).uniqueResult();
		tr.commit();
		ss.close();
		return s1;
	}

	@Override
	public String put(Staff t, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void post(Staff t) {
		// TODO Auto-generated method stub
		
	}

}
