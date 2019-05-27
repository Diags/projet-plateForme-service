package monartisant.com.projetartisant.ws;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioSmsSender implements SmsSender {
    @Autowired
    private  TwilioConfig twilioConfig;
    @Override
    public void sendSms(SmsRequest smsRequest) {
if(isPhoneNumbervalide(smsRequest.getPhoneNumber())){
        PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
        String message = smsRequest.getMessage();
        MessageCreator creator = Message.creator(to, from,message);
        creator.create();
    }
    else {
        throw new IllegalArgumentException("Phone number ["+smsRequest.getPhoneNumber()+"] is not valid number");
    }
}

    private boolean isPhoneNumbervalide(String phoneNumber) {
        return true;
    }
    }
