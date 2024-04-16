package com.theCaffeine.mes.scrt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomAuthenticationProvider implements AuthenticationProvider{
	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username=(String) authentication.getPrincipal();
		String password=(String) authentication.getCredentials();
		
		CustomUserDetails user = (CustomUserDetails)userDetailsService.loadUserByUsername(username);
		
		if(!matchPassword(password, user.getPassword())) {
			throw new BadCredentialsException("비밀번호 안맞음!!!!!");
		}
		
		if(!user.isEnabled()) {
			throw new BadCredentialsException("계정활성화 안되있음!!!!!");
		}
		
		return new UsernamePasswordAuthenticationToken(username,password,user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
	private boolean matchPassword(String loginPwd, String password) {
        return loginPwd.equals(password);
    }


}
