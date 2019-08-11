package monartisant.com.projetartisant.ws;

import monartisant.com.projetartisant.config.SecurityConstants;
import monartisant.com.projetartisant.model.Token;
import monartisant.com.projetartisant.model.User;
import monartisant.com.projetartisant.repository.TokenRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TokenService {
    private static final Logger LOGGER = LogManager.getLogger(TokenService.class);

    @Value("${auth.token.validity.duration:180}")
    private int tokenValidityDuration;
    @Autowired
    private TokenRepository tokenRepository;
    public void  createUserWithToken(User user , String token ){
        Token myToken = new Token(null, token,  new DateTime().plusDays(tokenValidityDuration).toDate(),new DateTime().toDate() , new DateTime().toDate() ,user);
        tokenRepository.save(myToken);
        LOGGER.debug("in TokenService token is create with {} ", myToken);
    }
}
