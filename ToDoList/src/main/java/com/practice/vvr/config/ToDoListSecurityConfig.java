package com.practice.vvr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class ToDoListSecurityConfig extends WebSecurityConfigurerAdapter{	
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		UserBuilder user = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(user.username("Test").password("Pass123").roles("USER"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/showLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
		
	
}
