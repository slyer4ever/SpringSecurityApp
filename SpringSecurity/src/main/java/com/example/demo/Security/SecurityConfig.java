package com.example.demo.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Repository.CompteRepository;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
		private CompteRepository compteRepository;
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
		
		/*
			 http.httpBasic()
	            .and()
	            .authorizeRequests()
	            .antMatchers("/**")
	            .authenticated(); // Use Basic authentication
			
			
			http.csrf().disable().authorizeRequests()
		.antMatchers("/*").authenticated()
		.antMatchers("/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/All_ET").hasAuthority("ADMIN")
		.antMatchers("/**").hasAnyAuthority("ADMIN","USER")
		//.antMatchers("/**").permitAll()
		.and()
		.formLogin();*/
			
		/*	http.csrf().disable()
            .authorizeRequests().anyRequest().authenticated()
            .and().httpBasic();*/
	
		}
		
		
		
		@Override
		protected void configure(
		AuthenticationManagerBuilder auth) throws Exception {
							auth.userDetailsService(new UserDetailsService() {
							@Override
							public UserDetails loadUserByUsername(String username)
							throws UsernameNotFoundException {
							return compteRepository.findById(username).orElse(null);
							}
							});
		}
		
		
		/*
		
		@Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	            .inMemoryAuthentication()
	            .withUser("NHA").password("123").roles("ADMIN");
	}
		
		*/
		
}