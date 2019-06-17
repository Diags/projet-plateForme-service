package monartisant.com.projetartisant.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProfessional {
    private String categoryName;
    private Boolean contacterViasTel;
    private Boolean contacterViasWhatshap;
    private String cout;
    private String entrepriseName;
    private String experience;
    private String ifu;
    private String jour;
    private String langEng;
    private String langFr;
    private String pays;
    private String raison;
    private List<String> tags;
    private String telephone;
    private String telephone2;
    private String whatsapp;
}
