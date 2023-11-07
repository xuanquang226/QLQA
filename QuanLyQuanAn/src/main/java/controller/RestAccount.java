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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.DAOAccount;
import dao.DAORole;
import dto.TupleDTO;
import model.Account;
import model.Role;
import security.JwtProvider;

@RestController
@ComponentScan(value = { "dao" })
public class RestAccount {

	private DAOAccount da;
	private DAORole dr;
	private AuthenticationManager authenticationManager;
	private PasswordEncoder passwordEncoder;
	private JwtProvider jwtProvider;

	@Autowired
	public RestAccount(DAOAccount da, DAORole dr, AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
		this.da = da;
		this.dr = dr;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.jwtProvider = jwtProvider;
	}

//	@PostMapping(value = "/api/login")
//	public Account getUser(@RequestBody Account a, @RequestHeader("Authorization") String token) {
//		return da.login(a.getUsername());
//	}

	@PostMapping(value = "/api/account")
	public Account addAccount(@RequestBody Account b) {
		return da.addAccount(b);
	}

	@PostMapping(value = "/api/login2")
	public TupleDTO<String, Account> login(@RequestBody Account a) {
		String token = "";
		TupleDTO<String, Account> tokenAndAccount = new TupleDTO<>();
		Authentication auth = this.authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(a.getUsername(), a.getPassword()));
		if(auth.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(auth);
			token = "Bearer " + jwtProvider.generateJWT(auth);
			tokenAndAccount.setToken(token);
			tokenAndAccount.setAccount(da.getAccount(a.getUsername()));
			return tokenAndAccount;
		}else {
			return null;
		}
	}

	@PostMapping(value = "/api/signup")
	public String signUp(@RequestBody Account a) {
		Role role = dr.getRole("STAFF");

		Account newAccount = a;
		newAccount.setUsername(a.getUsername());
		newAccount.setTypeA(false);
		newAccount.setPassword(passwordEncoder.encode(a.getPassword()));
		newAccount.setlRole(Collections.singletonList(role));

		da.addAccount(newAccount);

		return "Signup success";
	}

	@PostMapping(value = "/api/get")
	public Account getAccountt(@RequestParam String username) {
		return da.getAccount(username);
	}
}
