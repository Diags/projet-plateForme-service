package monartisant.com.projetartisant.model;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated profession ID")
    private Long id ;
    @ApiModelProperty(notes = "profession name")
    private String name;
    @ApiModelProperty(notes = "The image name of the profession")
    private String photo;
    @ApiModelProperty(notes = "The profession description")
    private String description;
    @ApiModelProperty(notes = "The List of user of this profession")
    @JsonBackReference
    @OneToMany(mappedBy = "profession")
    private List<User> users;
    @ApiModelProperty(notes = "The category of this profession")
    @JsonManagedReference
    @ManyToOne
    private Category category;

}
