package com.ebook.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ebook.config.CustomUserDetails;
import com.ebook.utils.SecurityUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProviderImpl implements JwtProvider {

	@Value("${app.jwt.secret}")
	private String JWT_SECRET_KEY;

	@Value("${app.jwt.expiration-in-ms}")
	private long JWT_EXPIRATION_IN_MS;

	@Override
	public String generateToken(CustomUserDetails userDetails) {

		String authorities = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));

		//System.out.println("authorities=" + authorities);

		Key key = Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));

		// System.out.println("key=" + key);

		String token = Jwts.builder().setSubject(userDetails.getUsername()).claim("roles", authorities)
				.claim("userId", userDetails.getUser().getId())
				.setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_IN_MS))
				.signWith(key, SignatureAlgorithm.HS512).compact();

		// System.out.println("token=" + token);

		/*
		 * String token= Jwts.builder().setSubject(userDetails.getUsername())
		 * .claim("roles", authorities) .claim("userId", userDetails.getId())
		 * .setExpiration(new Date(System.currentTimeMillis()+JWT_EXPIRATION_IN_MS))
		 * .signWith(key,SignatureAlgorithm.HS512) .compact();
		 * System.out.println("token="+token); return token;
		 */

		return token;
	}

	@Override
	public Authentication getAuthentication(HttpServletRequest request) {

		Claims claims = extractClaims(request);

		if (claims == null) {
			return null;
		}

		String username = claims.getSubject();
		int userid = claims.get("userId", Integer.class);

		Set<SimpleGrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
				.map((role) -> new SimpleGrantedAuthority(role)).collect(Collectors.toSet());

		UserDetails userDetails = CustomUserDetails.builder().userName(username).authorities(authorities).id(userid)
				.build();

		if (username == null) {
			return null;
		}
		return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
	}

	@Override
	public boolean isTokenValid(HttpServletRequest request) {
		Claims claim = extractClaims(request);

		if (claim == null) {
			return false;
		}

		if (claim.getExpiration().before(new Date())) {
			return false;
		}

		return true;
	}

	@Override
	public Claims extractClaims(HttpServletRequest request) {

		String token = SecurityUtil.extractAuthTokenFromRequest(request);

		if (token == null) {
			return null;
		}

		Key key = Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));

		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

}
