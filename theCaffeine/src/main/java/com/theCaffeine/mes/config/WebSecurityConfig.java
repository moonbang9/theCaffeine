package com.theCaffeine.mes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.theCaffeine.mes.scrt.CustomAccessDeniedHandler;
import com.theCaffeine.mes.scrt.CustomLoginSuccessHandler;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired UserDetailsService detailService;
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/*", "/home").permitAll()
				//.antMatchers("/empList").hasRole("ADMIN") //관리자만 접근 가능. 대소문자 구
				//.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
						  .usernameParameter("userid")
						  .loginProcessingUrl("/userlogin")
						  .successHandler(successHandler())
				.permitAll()
			)
			.logout((logout) -> logout
					.logoutSuccessUrl("/customLogout")
					.permitAll())
			/*.exceptionHandling().accessDeniedHandler(accessDeniedHandler() )*/
			.exceptionHandling(handler -> handler.accessDeniedHandler(accessDeniedHandler()) )
			//.csrf().disable() token 사용하기를 원하지 않을때 disable 
			.userDetailsService(detailService) //이게 아래 있는 default를 대체함
		;
		return http.build();
	}

/*	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("1111")
				.roles("USER")
				.build();

		UserDetails admin =
				 User.withDefaultPasswordEncoder()
					.username("admin")
					.password("1111")
					.roles(" ADMIN")
					.build();
		return new InMemoryUserDetailsManager(user,admin);
	} */
}