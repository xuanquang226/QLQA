package security;

import java.util.Date;

import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {
	
	private final String JWT_SECRET = "quanggg";
	private final long JWT_EXPIRE = 240000L;
	
	public String generateJWT(Authentication auth) {
		Date currentDate = new Date();
		Date expiredDate = new Date(currentDate.getTime() + JWT_EXPIRE);
		System.out.println(currentDate.getTime());
		String subject = auth.getName();
		
		String token = Jwts.builder()
							.setSubject(subject)
							.setIssuedAt(currentDate)
							.setExpiration(expiredDate)
							.signWith(SignatureAlgorithm.HS512, JWT_SECRET)
							.compact();
		return token;
	}
	
	public String getUsernameFromJwt(String token) {
		return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parse(token);
			return true;
		}catch(MalformedJwtException ex) {
			System.out.println("Invalid token");
		}catch(ExpiredJwtException ex) {
			System.out.println("Expired token");
		}
		return false;
	}
	
}
