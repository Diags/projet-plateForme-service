package monartisant.com.projetartisant.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class EmailSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public EmailStatus sendPlainText(String to, String token, String mdp) {
        return sendM(to, token,  mdp);
    }

    public EmailStatus sendHtml(String to, String token, String mdp) {
        return sendM(to, token, mdp );
    }

    private EmailStatus sendM(String to, String token, String mdp) {
        try {
            MimeMessage mails = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mails, true);

            String url = "http://localhost:4200";
            String body = "<strong>Activation Process</strong> <br/> <br/>" + "<a href = "
                    + url + "/confirmregister/"+ token + "> Click on link to finalize your activation </a><br/>" +
                    "<h4>Password: "+ mdp+"</h4>";
            helper.setFrom("noreplay@gmail.com");
            helper.setTo(to);
            helper.setSubject("Activation Process");
            helper.setText(body, true);


            javaMailSender.send(mails);
            LOGGER.info("Send email '{}' to: {}", to);
            LOGGER.info("SEND STAUS {} =  ","MESSAGE SENDS");
            return new EmailStatus(to, "toto", "ok").success();
        } catch (Exception e) {
            LOGGER.error(String.format("Problem with sending email to: {}, error message: {}", to, e.getMessage()));
            return new EmailStatus(to, "toto", "ok").error(e.getMessage());
        }
    }


    @Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }

}