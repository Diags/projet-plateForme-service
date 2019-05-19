package monartisant.com.projetartisant.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private int age;
    private boolean isBanned;
    private int numeroSiret;
    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;
    private String photoName;
    private String recommanderBy;
    @ManyToOne
    private Category category;
}
