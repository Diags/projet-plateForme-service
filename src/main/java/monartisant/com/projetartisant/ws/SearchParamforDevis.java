package monartisant.com.projetartisant.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchParamforDevis {
    private String user_name;
    private String user_lastName;
    private String user_town;
    private String user_codePostal;
    private String user_message;
}
