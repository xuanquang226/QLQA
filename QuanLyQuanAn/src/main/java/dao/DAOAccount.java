package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import dto.TupleDTO;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpServletRequest;
import model.Account;
import model.Role;
import security.JwtProvider;
import util.HibernateUtil;

@Component
public class DAOAccount {
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Autowired
	private DAORole dr;
	

	public String addAccount(Account a) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		
		Role role = dr.getRole("STAFF");

		Account newAccount = a;
		newAccount.setUsername(a.getUsername());
		newAccount.setTypeA(false);
		newAccount.setPassword(passwordEncoder().encode(a.getPassword()));
		newAccount.setLRole(Collections.singletonList(role));
		ss.saveOrUpdate(a);
		
		tr.commit();
		ss.close();
		return "Sign up success";
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
	
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}
