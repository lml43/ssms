package com.sinno.ssms.config;

import com.sinno.ssms.model.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    // TODO: stored in config, init when deploy
    private final String JWT_SECRET = "natest";

    /**
     * Create JWT
     *
     * @param userDetails
     * @return
     */
    public String generateToken(CustomUserDetails userDetails) {
        Date now = new Date();
        long jwt_expiration = 3600000L;
        Date expireDate = new Date(now.getTime() + jwt_expiration);

        return Jwts.builder()
                .setSubject(Long.toString(userDetails.getUserEntity().getId()))
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    /**
     * Get userEntity info from JWT
     *
     * @param token
     * @return
     */
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public Long getUserIdFromJWT(String token, boolean hasBearer) {
        String jwt = token;
        if(hasBearer){
            int tokenLength = token.split(" ").length;
            if(tokenLength == 3){
                jwt = token.split(" ")[2];
            } else {
                jwt = token.split(" ")[1];
            }
        }

        return getUserIdFromJWT(jwt);
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
