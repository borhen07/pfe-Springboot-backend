package com.RessourseHumaine.ConfigSecurity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.RessourseHumaine.Entity.Utilisateur;
import com.RessourseHumaine.Services.InscriptionService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final InscriptionService inscriptionService;
	private final BCryptPasswordEncoder passwordEncoder;

	
	@Autowired
	private UserDetailsService myUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	public SecurityConfig(InscriptionService inscriptionService, BCryptPasswordEncoder passwordEncoder) {
		super();
		this.inscriptionService = inscriptionService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return (UserDetailsService) email -> {
			Optional<Utilisateur> utilisateur = inscriptionService.findUserByEmail(email);
			if(utilisateur.isEmpty()) {
				throw new UsernameNotFoundException("No user found with email address: "+email);
			}
			return utilisateur.get();
			
		};
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.authorizeRequests().antMatchers("/login","/register","/activation"). permitAll()
		.anyRequest().authenticated().and()
		.exceptionHandling().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}


}
