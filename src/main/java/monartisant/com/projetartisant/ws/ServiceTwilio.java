package monartisant.com.projetartisant.ws;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceTwilio {
    @Autowired
    private TwilioSmsSender  twilioSmsSender;
public void smsdSms(SmsRequest smsRequest){
    this.twilioSmsSender.sendSms(smsRequest);
}
}
