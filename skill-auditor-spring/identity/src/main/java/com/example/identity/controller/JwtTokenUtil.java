package com.example.identity.controller;

import com.example.identity.service.DTO.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //generate token for user
    public String generateToken(UserDTO userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(UserDTO.USERNAME,userDetails.getUsername());
        claims.put(UserDTO.PASSWORD,userDetails.getPassword());
        claims.put(UserDTO.JOB_ROLE,userDetails.getJobRole());
        claims.put(UserDTO.ID,userDetails.getId());
        claims.put(UserDTO.FIRST_NAME,userDetails.getFirstName());
        claims.put(UserDTO.SURNAME,userDetails.getSurname());
        return tokenFactory(claims, userDetails.getUsername());
    }


    private String tokenFactory(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Boolean validateToken(String token, String username) {
        final String USERNAME = getListOfClaimsFromToken(token).get(UserDTO.USERNAME).toString();
        return (USERNAME.equals(username) && !isTokenExpired(token));
    }

    public String getIDFromToken(String token) {
        return getListOfClaimsFromToken(token).get(UserDTO.ID).toString();
    }

    public String getRoleFromToken(String token) {
        return getListOfClaimsFromToken(token).get(UserDTO.JOB_ROLE).toString();
    }

    private Claims getListOfClaimsFromToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody();
    }
}

