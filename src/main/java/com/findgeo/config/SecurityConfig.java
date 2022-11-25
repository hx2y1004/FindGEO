package com.findgeo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.findgeo.service.MemberService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

	private MemberService memberService;
	
    
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeRequests()
	        .mvcMatchers("/css/**", "/js/**", "/img/**").permitAll()
	        .mvcMatchers("/", "/members/**", "/item/**", "/images/**").permitAll()
	        .mvcMatchers("/admin/**").hasRole("ADMIN")
	        .anyRequest().authenticated()
		;
        
        http.formLogin()
	        .loginPage("/members/login")
	        .defaultSuccessUrl("/")
	        .usernameParameter("email")
	        .passwordParameter("password")
	        .failureUrl("/members/login/error")
	        .and()
	        .logout()
	        .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
	        .logoutSuccessUrl("/")
		;


		

//		http.csrf().disable();
        return http.build();
	}
	

	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}

