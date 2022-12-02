package com.example.project.jwt;

import com.example.project.entity.AccountDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${project-demo.jwtSecret}")
    private String jwtSecret;

    @Value("${project-demo.jwtExpirationMs}")
    private int jwtExpirationMs;

    private final Map<String, Object> customClaim = new HashMap<>();

/************************************************************************************************************************/

    public String generateStoreJwt(Authentication authentication){
        AccountDetailsImpl accountDetails = (AccountDetailsImpl) authentication.getPrincipal();

        //add customClaim role = STORE
        customClaim.clear();
        customClaim.put("role","STORE");

        return Jwts.builder().setSubject(accountDetails.getUsername())
                .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .addClaims(customClaim)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String generateBrandJwt(Authentication authentication){
        AccountDetailsImpl brandAccDetails = (AccountDetailsImpl) authentication.getPrincipal();

        //add customClaim role = BRAND
        customClaim.clear();
        customClaim.put("role","BRAND");

        return Jwts.builder().setSubject(brandAccDetails.getUsername())
                .setIssuedAt(new Date())
                .addClaims(customClaim)
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Jws<Claims> parseClaim(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
    }

    //Get Username from Token
    public String getUsernameFromJwt(String token){
        return parseClaim(token).getBody().getSubject();
    }

    //Get Role form Token
    public String getRoleFromJwt(String token){
        return parseClaim(token).getBody().get("role", String.class);
    }

    //Validate Token
    public boolean validateJwt(String token){
        try{
            parseClaim(token);
            return true;
        } catch (SignatureException e) {
            LOGGER.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            LOGGER.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            LOGGER.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            LOGGER.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}
