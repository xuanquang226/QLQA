package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import jakarta.persistence.Query;
import model.Account;
import util.HibernateUtil;

@Component
public class DAOAccount {
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();
	
//	@Autowired
//	private AuthenticationManager authenticationManager;

//	public Account login(String username, String password) {
//		Session ss = sf.openSession();
//		Transaction tr = ss.beginTransaction();
//
//		String sql = "from Account as a where a.username = :username";
//
//		Account a = ss.createQuery(sql, Account.class).setParameter("username", username)
//													.setParameter("password", password)
//													.uniqueResult();
//
//		tr.commit();
//		ss.close();
//		return a;
//	}

	public Account addAccount(Account s) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.saveOrUpdate(s);
		
		tr.commit();
		ss.close();
		return s;
	}
	
	public Account getAccount(String username) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String sql = "from Account as a where a.username = :username";
		Account a = ss.createQuery(sql, Account.class)
												.setParameter("username", username)
												.uniqueResult();
		tr.commit();
		ss.close();
		return a;
	}
	
//	public ResponseEntity<String> login(Account account){
//		Authentication auth = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
//		if(auth.isAuthenticated()) {
//			SecurityContextHolder.getContext().setAuthentication(auth);
//			return new ResponseEntity<String>("Login success", HttpStatus.OK);
//		}
//		return null;
//	}
}
