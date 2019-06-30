package monartisant.com.projetartisant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Pays {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "pays")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Collection<Adresse> adresses;
}
