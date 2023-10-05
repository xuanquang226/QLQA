package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import model.Account;
import model.Staff;
import util.HibernateUtil;


@Component
public class DAOStaff implements DAOCRUDInterface<Staff> {
	
	@Override
	public Staff get(long idAccount) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Account a = ss.get(Account.class, idAccount);
		long id = a.getIdS();
		
		
		String sql = "from Staff where :account = :idAccount";
		Staff s1 = ss.createQuery(sql, Staff.class).setParameter("account", id)
													.setParameter("idAccount", idAccount).uniqueResult();
		
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
