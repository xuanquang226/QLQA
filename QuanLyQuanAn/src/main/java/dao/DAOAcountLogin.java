package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import dto.TupleDTO;
import jakarta.servlet.http.HttpServletRequest;
import model.Account;
import security.JwtProvider;
import util.HibernateUtil;

@Component
public class DAOAcountLogin {
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	private AuthenticationManager authenticationManager;
	private JwtProvider jwtProvider;
	
	@Autowired
	public DAOAcountLogin(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
		this.authenticationManager = authenticationManager;
		this.jwtProvider = jwtProvider;
	}


	public TupleDTO<String, Account> login(Account a){
		System.out.println(a.getUsername());
		String token = "";
		TupleDTO<String, Account> tokenAndAccount = new TupleDTO<>();
		Authentication auth = this.authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(a.getUsername(), a.getPassword()));
		if(auth.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(auth);
			token = "Bearer " + jwtProvider.generateJWT(auth);
			tokenAndAccount.setToken(token);
			tokenAndAccount.setAccount(getAccount(a.getUsername()));
			return tokenAndAccount;
		}else {
			return null;
		}
	}
	
	public Account getAccountFromHeader(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		String token = "";
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			token = bearerToken.substring(7, bearerToken.length());
		}
		String username = jwtProvider.getUsernameFromJwt(token);		
		return getAccount(username);
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
}
