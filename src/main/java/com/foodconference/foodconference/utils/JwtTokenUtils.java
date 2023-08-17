package com.foodconference.foodconference.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class JwtTokenUtils {
    @Value("Liliya123")
    private String secret;
    @Value("30m")
    private Duration jwtLifeTime;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        List<String> roleList = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        claims.put("roles", roleList);
        Date dateStart = new Date();
        Date dateFinish = new Date(dateStart.getTime() + jwtLifeTime.toMillis());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(dateStart)
                .setExpiration(dateFinish)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

    }

    private Claims getClaimsToken(String token) {
        return (Claims) Jwts.parser()
                .setSigningKey(secret)
                .parse(token)
                .getBody();
    }
    public String getUserName(String token){
        return getClaimsToken(token).getSubject();
    }
    public List<String> getUserRoles(String token){
        return  getClaimsToken(token).get("roles",List.class);
    }
}

