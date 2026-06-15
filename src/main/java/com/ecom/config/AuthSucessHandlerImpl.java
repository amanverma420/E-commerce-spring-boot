package com.ecom.config;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.ecom.model.UserDtls;
import com.ecom.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthSucessHandlerImpl implements AuthenticationSuccessHandler {

	@Autowired
	@org.springframework.context.annotation.Lazy
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String email = authentication.getName();
		UserDtls user = userService.getUserByEmail(email);
		if (user != null) {
			userService.resetAttempt(user.getId());
		}
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		Set<String> roles = AuthorityUtils.authorityListToSet(authorities);
		
		if(roles.contains("ROLE_ADMIN"))
		{
			response.sendRedirect("/admin/");
		}else {
			response.sendRedirect("/");
		}
		
	}

}
