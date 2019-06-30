package monartisant.com.projetartisant.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

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
    @JsonManagedReference
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Pays pays;
    @OneToOne(mappedBy = "adresse")
    private User user;
}
