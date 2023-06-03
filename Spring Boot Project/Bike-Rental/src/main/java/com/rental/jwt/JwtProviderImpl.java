package com.rental.jwt;

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
import org.springframework.util.StringUtils;

import com.rental.config.CustomUserDetails;
import com.rental.util.AppConstant;

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

		String authorites = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));

		Key key = Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));

		String token = Jwts.builder().setSubject(userDetails.getUsername()).claim("roles", authorites)
				.claim("userId", userDetails.getUserId())
				.setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_IN_MS))
				.signWith(key, SignatureAlgorithm.HS512).compact();

		return token;
	}

	@Override
	public Authentication getAuthentication(HttpServletRequest request) {

		Claims claim = extractClaims(request);

		if (claim == null) {
			return null;
		}

		String username = claim.getSubject();
		Integer userid = claim.get("userId", Integer.class);

		Set<SimpleGrantedAuthority> authorities = Arrays.stream(claim.get("roles").toString().split(","))
				.map((role) -> new SimpleGrantedAuthority(role)).collect(Collectors.toSet());

		UserDetails userDetails = CustomUserDetails.builder().userName(username).userId(userid).authorities(authorities)
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
		String token = extractAuthTokenFromRequest(request);

		if (token == null) {
			return null;
		}

		Key key = Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));

		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

	private String extractAuthTokenFromRequest(HttpServletRequest request) {

		String bearerToken = request.getHeader(AppConstant.AUTH_HEADER);

		if (StringUtils.hasLength(bearerToken) && bearerToken.startsWith(AppConstant.AUTH_TOKEN_PREFIX)) {
			return bearerToken.substring(7);
		}

		return null;
	}

}
