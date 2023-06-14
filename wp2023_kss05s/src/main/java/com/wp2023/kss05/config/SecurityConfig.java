package com.wp2023.kss05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/all").permitAll()
			.antMatchers("/guest/**").hasRole("GUEST")
			.antMatchers("/member/**").hasRole("MEMBER")
			.antMatchers("/topmem/**").hasRole("TOPMEM")
			.antMatchers("/manager/**").hasRole("MANAGER")
			.antMatchers("/admin/**").hasRole("ADMIN");
			
		http.formLogin().loginPage("/kss05login").defaultSuccessUrl("/kss05exam5");
		
		http.logout().logoutUrl("/kss05logout").invalidateHttpSession(true);
		
	}
	
	
}
