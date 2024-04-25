package com.theCaffeine.mes.comm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.theCaffeine.mes.scrt.CustomAccessDeniedHandler;
import com.theCaffeine.mes.scrt.CustomLoginFailureHandler;
import com.theCaffeine.mes.scrt.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired 
	UserDetailsService detailService;
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public AuthenticationFailureHandler lgfailureHandler() {
		return new CustomLoginFailureHandler();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/","/main","/memb/register" ,"/memb/login","/memb/changepw",
						"/memb/changeid","/memb/findid","/memb/findpw","/assets/**","/fonts/**",
						"/js/**","/scss/**", "/accessError","/orderMng","/prdtHistList",
						"/prdtPerformanceList","/orderlist","/situation","/stocklist").permitAll()
//				.antMatchers("/login").permitAll()
				.antMatchers("/fclt/**").hasAnyRole("FCLT","ADMIN","REGISTER")
				.antMatchers("/sales/**").hasAnyRole("SALE","ADMIN","REGISTER")
				.antMatchers("/prdt/**","/prdt/**/**").hasAnyRole("PRDT","ADMIN","REGISTER")
				.antMatchers("/mtrl/**").hasAnyRole("MTRL","ADMIN","REGISTER")
				.antMatchers("/qlty/**").hasAnyRole("QLTY","ADMIN","REGISTER")
                //.antMatchers("/**").hasRole("ADMIN")

				.anyRequest().authenticated()
			)
			// 람다식
//			.formLogin((form) -> form
//					.loginPage("/login")
//					.permitAll()
//			)
			.formLogin().loginPage("/memb/login")
						.loginProcessingUrl("/memb/userlogin")
						.successHandler(successHandler())
//						.defaultSuccessUrl("/", true) //로그인 하면 무조건 메인 페이지로  
						.permitAll()
						 .failureHandler(lgfailureHandler())
						
			.and()
//			.logout((logout) -> logout.permitAll())
			.logout().logoutSuccessUrl("/memb/login")
			 .permitAll()
			.and()
//			.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
			.exceptionHandling( handler -> handler.accessDeniedHandler(accessDeniedHandler()) )
			.csrf().disable()
			.userDetailsService(detailService);
		
		return http.build();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails admin = 
//				User.withDefaultPasswordEncoder()
//					.username("admin")
//					.password("1111")
//					.roles("ADMIN")
//					.build();
//		
//		UserDetails user =
//				User.withDefaultPasswordEncoder()
//					.username("user")
//					.password("1111")
//					.roles("USER")
//					.build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
}