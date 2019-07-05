package monartisant.com.projetartisant.errorHandle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidTokenRequestException extends RuntimeException {

    private final String tokenType;
    private final String token;
    private final String message;

    public InvalidTokenRequestException(String tokenType, String token, String message) {
        super(String.format("Invalid [%s] token [%s] : %s", token, tokenType, message));
        this.tokenType = tokenType;
        this.token = token;
        this.message = message;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String getMessage() {
        return message;
    }
}