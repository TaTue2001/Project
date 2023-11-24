package com.example.Project.Security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.Project.Entity.Account;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;


import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class JwtTokenProvider {
	private final String JWT_SECRET="admin";
	
	private final long JWT_EXPIRATION = 604800000L;
	
	private final long JWT_REFRESH_EXPIRATION = 60480000000L;
	
//	private final String TOKEN_PREFIX="Bearer ";
	
//	private final String HEADER_STRING=	"Authorization";
//	 Collection<>
	//Tạo token
    public String generateToken(AccountUserDetail ac) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(ac.getAccount().getUserName())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .claim("role",ac.getAuthorities())
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }
    public String generateRefreshToken(AccountUserDetail ac) {
    	Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_REFRESH_EXPIRATION);

        return Jwts.builder()
                   .setSubject(ac.getAccount().getUserName())
                   .setIssuedAt(now)
                   .setExpiration(expiryDate)
                   .claim("role",ac.getAuthorities())
                   .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                   .compact();
    }
    
    public String getUserNameFromJWT(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(JWT_SECRET)
                            .parseClaimsJws(token)
                            .getBody();
        return claims.getSubject();
    }
    
    public String getRoleFromJWT(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(JWT_SECRET)
                            .parseClaimsJws(token)
                            .getBody();
        return (String) claims.get("role");
    }
    
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
//            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
//            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
//            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
//            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
