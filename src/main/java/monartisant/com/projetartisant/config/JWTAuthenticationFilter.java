package monartisant.com.projetartisant.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import monartisant.com.projetartisant.model.User;
import monartisant.com.projetartisant.ws.JwtTokenProvider;
import monartisant.com.projetartisant.ws.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
  public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
      @Autowired
      private JwtTokenProvider jwtTokenProvider;

    // We use auth manager to validate the user credentials
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super();
        this.authenticationManager = authenticationManager;
        //By default, UsernamePasswordAuthenticationFilter listens to "/login" path.
        // In our case, we use "/signin". So, we need to override the defaults.
      //  this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/signin/**", "POST"));
    }

    @Override
    public org.springframework.security.core.Authentication attemptAuthentication(HttpServletRequest request,
                                                                                  HttpServletResponse response) throws AuthenticationException {

        LoginParam loginParam = null;
        try {
            loginParam = new ObjectMapper().readValue(request.getInputStream(), LoginParam.class);
            System.out.println("******************************");

            System.out.println(loginParam.getEmail());
            System.out.println(loginParam.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginParam.getEmail(),
                        loginParam.getPassword(), Collections.emptyList()
                ));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse
            response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        User springUser = (User) authResult.getPrincipal();
        String newToken =  jwtTokenProvider.generateToken(springUser);
        response.addHeader(SecurityConstants.HEADER_STRING,
                SecurityConstants.TOKEN_PREFIX + newToken);
   }
}