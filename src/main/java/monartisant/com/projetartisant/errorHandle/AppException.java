package monartisant.com.projetartisant.errorHandle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class AppException   extends RuntimeException {
    public AppException(String message) {
            super(message);
        }

    public AppException(String message, Throwable cause) {
            super(message, cause);
        }

}