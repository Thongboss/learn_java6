package com.example.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.api.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter{
//	@Autowired 
//	@Lazy
//	BCryptPasswordEncoder pe;
	
	@Autowired
	private UserService userService;
	
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//		.withUser("user1").password(pe.encode("123")).roles("GUEST")
//		.and()
//		.withUser("user2").password(pe.encode("123")).roles("GUEST","USER")
//		.and()
//		.withUser("user3").password(pe.encode("123")).roles("GUEST","USER","ADMIN");
		auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.csrf().disable().cors().disable();
		
		// phân quyền sử dụng
//		http.authorizeRequests().anyRequest().permitAll(); cho phép tất cả truy cập
		
		http.authorizeRequests()
		.antMatchers("/home/admins").hasRole("ADMIN")
		.antMatchers("/home/users").hasAnyRole("ADMIN","USER")
		.antMatchers("/home/authenticated").authenticated()
		.anyRequest().permitAll(); // anonymous
		
		// phân quyền sử dụng
		http.authorizeRequests()
		.antMatchers("/rest/authorize","/rest/authorize/**").hasAnyRole("ADMIN","USER")
		.anyRequest().permitAll();
//		http.httpBasic();
		
		// Điều khiển lỗi truy cập không đúng vai trò
		http.exceptionHandling().accessDeniedPage("/auth/access/denied"); 
		
//		String pas = http.formLogin().passwordParameter("password").toString();
//		String user = http.formLogin().passwordParameter("username").toString();
//		System.out.println("pass: "+pas);
//		System.out.println("user: "+user);

        http.formLogin().loginPage("/auth/login/form")
            .loginProcessingUrl("/auth/login")
            .defaultSuccessUrl("/auth/login/success",false)
            .failureUrl("/auth/login/error")
            .usernameParameter("username")
            .passwordParameter("password");
        //remember me
        http.rememberMe().rememberMeParameter("rememberme");
        
        //Oauth2 Đăng nhập từ mạng xã hội
        http.oauth2Login().loginPage("/auth/login/form")
        .defaultSuccessUrl("/auth/login/successs",true)
        .failureUrl("/auth/login/error")
        .authorizationEndpoint()
        .baseUri("/oauth2/authorization");
        
        http.logout().logoutUrl("/auth/logoff").logoutSuccessUrl("/auth/logoff/success");
        
		
//		http.httpBasic();
	}
	
}
