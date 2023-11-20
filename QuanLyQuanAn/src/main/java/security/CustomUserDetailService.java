package security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dao.DAOAccount;
import dao.DAORole;
import model.Account;
import model.Role;

@Service
@ComponentScan(basePackageClasses = DAOAccount.class)
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private DAOAccount daoAccount;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = daoAccount.getAccount(username);
		return new User(account.getUsername(), account.getPassword(), listAuthorize(account.getlRole()));
	}
	
	
	public List<GrantedAuthority> listAuthorize(List<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
