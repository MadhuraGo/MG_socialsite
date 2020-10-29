package com.cg.socialsite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		

		http
			.authorizeRequests()
			.anyRequest().authenticated().and()
			.httpBasic().and().csrf().disable();
		/*		
				.antMatchers("/socialsite").hasRole("USER")
				.and()
				.authorizeRequests()
				.antMatchers("/socialsite/owner/**").hasRole("PROFILE_OWNER")
				.and()
				.authorizeRequests()
				.antMatchers("/socialsite/deletecomment").hasAnyRole("PROFILE_OWNER","CMT_OWNER")
				.anyRequest().authenticated()
				.and()
		        .httpBasic();
		*/
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("socialsite").password(getEncodedPwd().encode("socialsite")).roles("USER")
			.and()
			.withUser("profile_owner").password(getEncodedPwd().encode("socialsite")).roles("PROFILE_OWNER");
			
			
			
	}
	
	
	@Bean
	public PasswordEncoder getEncodedPwd() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}