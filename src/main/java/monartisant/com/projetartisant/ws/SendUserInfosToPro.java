package monartisant.com.projetartisant.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class SendUserInfosToPro {
private String nom;
private String prenom ;
private String ville ;
private String codePostal;
private String description;

}
