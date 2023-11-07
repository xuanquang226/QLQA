package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import jakarta.persistence.Query;
import model.Account;
import util.HibernateUtil;

@Component
public class DAOAccount {
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();

	public Account login(String username, String password) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String sql = "from Account as a where a.username = :username and a.password = :password ";

		Account a = ss.createQuery(sql, Account.class).setParameter("username", username)
													.setParameter("password", password)
													.uniqueResult();

		tr.commit();
		ss.close();
		return a;
	}

	public Account addAccount(Account s) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.merge(s);
		
		tr.commit();
		ss.close();
		return s;
	}
}
