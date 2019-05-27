package monartisant.com.projetartisant.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data @AllArgsConstructor @NoArgsConstructor
public class TwilioConfig {
    @Value("${twilio.account_sid}")
    private  String accountSid;
    @Value("${twilio.auth_token}")
    private  String authToken;
    @Value("${twilio.trial_number}")
    private  String trialNumber;


}
