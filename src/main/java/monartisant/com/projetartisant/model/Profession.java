package monartisant.com.projetartisant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private String photo;
    private String description;
    @OneToMany(mappedBy = "profession")
    private List<User> users;
    @ManyToOne
    private Category category;

}
