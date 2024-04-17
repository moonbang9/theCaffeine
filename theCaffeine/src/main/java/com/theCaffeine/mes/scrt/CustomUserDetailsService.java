package com.theCaffeine.mes.scrt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.theCaffeine.mes.comm.user.mapper.EnterpriseMapper;
import com.theCaffeine.mes.comm.user.model.EnterpriseVO;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	 private EnterpriseMapper enterMapper ;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EnterpriseVO user = enterMapper.loginChk(username);
		if(username==null) {
			throw new UsernameNotFoundException(username);
		}
		
		System.out.println("CustomUserDetailsService 들어왔다!!!!!!!!!!!!!!!!");
		return null;
	}
	
}
