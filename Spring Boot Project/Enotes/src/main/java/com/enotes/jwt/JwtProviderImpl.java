package com.enotes.jwt;

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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.enotes.config.CustomUserDetails;
import com.enotes.util.SecurityUtil;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProviderImpl implements JwtProvider {

	@Value("${app.jwt.secret}")
	private String JWT_SCRET_KEY;

	@Value("${app.jwt.expiration-in-ms}")
	private long JWT_EXPIRATION_IN_MS;

	@Override
	public String generateToken(CustomUserDetails auth) {

		String authorities = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));
	
		
		Key key=Keys.hmacShaKeyFor(JWT_SCRET_KEY.getBytes(StandardCharsets.UTF_8));		
		
		return Jwts.builder().setSubject(auth.getUsername())
				.claim("roles", authorities)
				.claim("userId", auth.getId())
				.setExpiration(new Date(System.currentTimeMillis()+JWT_EXPIRATION_IN_MS))
				.signWith(key,SignatureAlgorithm.HS512)
				.compact();
	}

	@Override
	public Authentication getAuthentication(HttpServletRequest request) {
		
		Claims claims=extractClaims(request);
		
		if(claims==null)
		{
			return null;
		}
		
		String username=claims.getSubject();
		int userId=claims.get("userId",Integer.class);
		
		Set<GrantedAuthority> authorities=Arrays.stream(claims.get("roles").toString().split(","))
										.map(SecurityUtil::convertToAuthority)
										.collect(Collectors.toSet());
		
		UserDetails userDetails=CustomUserDetails.builder()
								.id(userId)
								.userName(username)
								.authorities(authorities)
								.build();
		
		if(username==null)
		{
			return null;
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails,"", authorities);
		
	}

	@Override
	public boolean isTokenValid(HttpServletRequest request) {
		
		
		Claims claim=extractClaims(request);
		
		if(claim==null)
		{
			return false;
		}
		
		if(claim.getExpiration().before(new Date()))
		{
			return false;
		}
		
		return true;
	}
	
	@Override
	public Claims extractClaims(HttpServletRequest request)
	{
		String token=SecurityUtil.extractAuthTokenFromRequest(request);
		
		if(token == null)
		{
			return null;
		}
		Key key=Keys.hmacShaKeyFor(JWT_SCRET_KEY.getBytes(StandardCharsets.UTF_8));
		
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	

}
