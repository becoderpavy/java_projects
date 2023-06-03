package com.prog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService getUserDetails() {
		return new CustomUserDetailService();
	}

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	public DaoAuthenticationProvider getDaoProvider() {
		DaoAuthenticationProvider d = new DaoAuthenticationProvider();
		d.setUserDetailsService(getUserDetails());
		d.setPasswordEncoder(getPasswordEncoder());
		return d;
	}
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getDaoProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		  http.authorizeRequests().antMatchers("/user/**").hasRole("USER")
		  .antMatchers("/**").permitAll().and().formLogin().and().csrf().disable();
		 
		
		/*
		 * http.authorizeRequests().antMatchers("/user/**").hasRole("USER").antMatchers(
		 * "/**").permitAll().and()
		 * .formLogin().loginPage("/login").loginProcessingUrl("/dologin").
		 * defaultSuccessUrl("/user/home").and() .csrf().disable();
		 */
	}

}
