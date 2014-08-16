package com.starfarers.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.starfarers.domain.user.Role;
import com.starfarers.service.user.UserService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private transient DataSource dataSource;
	
	@Autowired
	private transient LoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	private transient UserService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userService)
				.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
        	.authorizeRequests()
        		.antMatchers("/user/**").authenticated()
        		.antMatchers("/admin/**").hasAnyRole(Role.ADMINISTRATOR.getName())
        		.antMatchers("/editor/**").hasAnyRole(Role.GAME_MASTER.getName())
        		.antMatchers("/master/**").hasAnyRole(Role.ADMINISTRATOR.getName(), Role.GAME_MASTER.getName())
        		.and()
	        .formLogin()
	        	.loginPage("/login")
	        	.successHandler(successHandler())
	        	.and()
	        .logout()
	        	.logoutSuccessUrl("/")
	        	.and()
	        ;
    }
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return loginSuccessHandler;
	}

}
