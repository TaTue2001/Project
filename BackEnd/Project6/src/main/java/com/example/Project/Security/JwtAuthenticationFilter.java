package com.example.Project.Security;

import java.io.IOException;
import java.util.Collection;
//import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
//import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.Project.Entity.Customer;
import com.example.Project.Entity.Employee;
import com.example.Project.Interface.Service.IPersonService;
import com.example.Project.Service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    private IPersonService<?> iPersonService;
    
    @Autowired
    private AccountService accountService;
    
    private static String Secret_key="admin";
    
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
            // Lấy jwt từ request
            String jwt = getJwtFromRequest(request);
            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                // Lấy id user từ chuỗi jwt
                String userName = tokenProvider.getUserNameFromJWT(jwt);
//                String role=tokenProvider.getRoleFromJWT(userName);
                UserDetails userDetails =  accountService.loadUserByUsername(userName);
                if(userDetails != null) {
                    // Nếu người dùng hợp lệ, set thông tin cho Seturity Context
                    UsernamePasswordAuthenticationToken  authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
		filterChain.doFilter(request, response);
	}

	public Object getUser(HttpServletRequest request) {
		 String jwt = getJwtFromRequest(request);
		 String userName="";
		 Collection<? extends GrantedAuthority> role=null;
		 UserDetails userDetails =null;
		 Object person=null;
         if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
             userName = tokenProvider.getUserNameFromJWT(jwt);
             userDetails =  accountService.loadUserByUsername(userName);
             role=userDetails.getAuthorities();
             if(userDetails != null) {
                 // Nếu người dùng hợp lệ, set thông tin cho Seturity Context
//                 UsernamePasswordAuthenticationToken  authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
//                 authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                 SecurityContextHolder.getContext().setAuthentication(authentication);
                 String roles=role.toString();
                 if(roles.equals("CUSTOMER")) {
                	 person=iPersonService.getPerson(userName,Customer.class);
                 }
                 else {
                	 person=iPersonService.getPerson(userName,Employee.class);
                 }
                
             }
         }
         return person;
	}
	
	public Object getCustomer() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		Object userDetails=authentication.getPrincipal();
		return userDetails;
	}
	
	public String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
		return null;
	}
    
    

}
