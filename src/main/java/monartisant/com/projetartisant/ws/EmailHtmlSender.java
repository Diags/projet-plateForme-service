package monartisant.com.projetartisant.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
@Component
public class EmailHtmlSender {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public EmailStatus send(String to, String subject, String templateName, Context context) {
        String body = templateEngine.process(templateName, context);
        return emailSender.sendHtml(to, subject, body);
    }
}