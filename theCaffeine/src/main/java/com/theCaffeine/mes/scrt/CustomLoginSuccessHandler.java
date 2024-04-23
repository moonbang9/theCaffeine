package com.theCaffeine.mes.scrt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	 private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		String username = auth.getName();
        logger.info("Successful login by user: {}", username);
		log.warn("Login Success");
		
		List<String> roleNames = new ArrayList<>();
		// Collection<Authority> ==> List<String>
		auth.getAuthorities().forEach(authority -> { roleNames.add(authority.getAuthority()); });
		if (roleNames.contains("ROLE_REGISTER")) {
            response.sendRedirect("/main");
        } else {
            response.sendRedirect("/main");
        }
    }
}