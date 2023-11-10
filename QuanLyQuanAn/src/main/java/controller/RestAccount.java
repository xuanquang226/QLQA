package controller;

import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOAccount;
import dao.DAOAcountLogin;
import dao.DAORole;
import dto.TupleDTO;
import jakarta.servlet.http.HttpServletRequest;
import model.Account;
import model.Role;
import security.JwtProvider;

@RestController
@ComponentScan(value = { "dao" })
public class RestAccount {
	
	private DAOAcountLogin daoAcountLogin;
	private DAOAccount da;
	
	@Autowired
	public RestAccount(DAOAcountLogin daoAcountLogin, DAOAccount da) {
		this.daoAcountLogin = daoAcountLogin;
		this.da = da;
	}

	@PostMapping(value = "/api/login")
	public TupleDTO<String, Account> login(@RequestBody Account a) {		
		return daoAcountLogin.login(a);
	}

	@PostMapping(value = "/api/signup")
	public String signUp(@RequestBody Account a) {		
		return da.addAccount(a);
	}

	@PostMapping(value = "/api/get")
	public Account getAccountFromHeader(HttpServletRequest request) {		
		return daoAcountLogin.getAccountFromHeader(request);
	}
}
