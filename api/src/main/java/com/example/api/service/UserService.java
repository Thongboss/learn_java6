package com.example.api.service;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.api.entity.Account;
import com.example.api.repository.AccountRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private AccountRepository account;
	
	@Autowired
	@Lazy
	private BCryptPasswordEncoder pe;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Account acc = account.findById(username).get();
			
//			System.out.println("user name: "+pe.encode(acc.getPassword()));
			
			//tạo userdetails từ account
			String password = acc.getPassword();
			String[] roles = acc.getAuthorities().stream()
					.map(au -> au.getRole().getId())
					.collect(Collectors.toList()).toArray(new String[0]);
			return User.withUsername(username)
					.password(pe.encode(password))//pe.encode(password)
					.roles(roles).build();
		} catch (Exception e) {
			throw new UsernameNotFoundException(username + "not found");
		}
	}
	
	public void loginFormOauth2(OAuth2AuthenticationToken oauth2) {
//		String fullName = oauth2.getPrincipal().getAttribute("name");
		String email = oauth2.getPrincipal().getAttribute("email");
		String password = Long.toHexString(System.currentTimeMillis());
		
		UserDetails user = User.withUsername(email)
				.password(pe.encode(password)).roles("GUEST").build();
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
	
	
}
