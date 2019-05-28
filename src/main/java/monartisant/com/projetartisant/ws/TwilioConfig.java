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
    @Value("${twilio.account_sid:AC9f14bbd670ff6e49555da18cf537564d}")
    private  String accountSid;
    @Value("${twilio.auth_token:2e21cdce09bade9ee89173a71c0d43ab}")
    private  String authToken;
    @Value("${twilio.trial_number:+16308830030}")
    private  String trialNumber;


}
