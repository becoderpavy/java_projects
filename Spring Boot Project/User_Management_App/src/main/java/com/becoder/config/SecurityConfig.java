package com.becoder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	public AuthenticationSuccessHandler customSuccessHandler;

	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider getDaoAuthProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());

		return daoAuthenticationProvider;
	}

	/*
	 * protected void configure(AuthenticationManagerBuilder auth) throws Exception
	 * { auth.authenticationProvider(getDaoAuthProvider()); }
	 */

	/*
	 * protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").
	 * antMatchers("/user/**").hasRole("USER")
	 * .antMatchers("/teacher/**").access("hasRole('ROLE_TEACHER')").antMatchers(
	 * "/**").permitAll().and()
	 * .formLogin().loginPage("/signin").loginProcessingUrl("/login").successHandler
	 * (customSuccessHandler) .and().csrf().disable();
	 * 
	 * }
	 */

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER")
				.antMatchers("/teacher/**").access("hasRole('ROLE_TEACHER')").antMatchers("/**").permitAll().and()
				.formLogin().loginPage("/signin").loginProcessingUrl("/login").successHandler(customSuccessHandler)
				.and().csrf().disable();

		http.authenticationProvider(getDaoAuthProvider());

		return http.build();
	}

}
