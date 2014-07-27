package com.starfarers.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER")
				.and()
				.withUser("admin").password("password").roles("ADMIN");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
        	.authorizeRequests()
        		.antMatchers("/admin/**").authenticated()
        		.antMatchers("/editor/**").authenticated()
        		.antMatchers("/master/**").authenticated()
        		.and()
	        .formLogin()
	        	.loginPage("/login")
	        	.and()
	        .logout()
	        	.logoutSuccessUrl("/");
    }

}
