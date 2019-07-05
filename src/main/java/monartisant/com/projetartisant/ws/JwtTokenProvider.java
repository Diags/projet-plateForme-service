package monartisant.com.projetartisant.ws;


import io.jsonwebtoken.*;
import monartisant.com.projetartisant.errorHandle.InvalidTokenRequestException;
import monartisant.com.projetartisant.model.User;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class JwtTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
    @Value("${auth.token.validity.duration:180}")
    private int tokenValidityDuration;
    @Value("${auth.token.SECRET:xreflite_ABB@abb.com}")
    private String SECRET ;
    public String generateToken(User user){

        logger.info("{generateToken} user  " + user.getEmail());
        String jwtToken = Jwts.builder()
                .setSubject(user.getEmail())
                .setExpiration(new DateTime().plusDays(tokenValidityDuration).toDate())
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .claim("roles", user.getRoles())
                .compact();
        logger.info("Token user  " + jwtToken);
        return jwtToken;
    }

    public Date getJwtExpirationDate(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
            throw  new InvalidTokenRequestException("InvalidSignatureJWT",authToken,"Invalid JWT signature");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
            throw  new InvalidTokenRequestException("ExpiredJWT",authToken,"Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
            throw  new InvalidTokenRequestException("InvalidJWT",authToken,"Invalid JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
            throw  new InvalidTokenRequestException("UnsupportedJWT",authToken,"Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
            throw  new InvalidTokenRequestException("claimsJWT",authToken,"JWT claims string is empty.");
        }
    }
}
