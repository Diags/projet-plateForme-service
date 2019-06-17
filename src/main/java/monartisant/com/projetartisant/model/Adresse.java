package monartisant.com.projetartisant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numeroRue;
    private String rue;
    private String name;
    private int codePostal;
    private String ville;
    private String pays;
    @OneToOne(mappedBy = "adresse")
    private User user;
}
