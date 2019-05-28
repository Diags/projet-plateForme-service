package monartisant.com.projetartisant.model;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "The database generated profession ID")
    private Long id ;
    @ApiModelProperty(notes = "profession name")
    private String name;
    @ApiModelProperty(notes = "The image name of the profession")
    private String photo;
    @ApiModelProperty(notes = "The profession description")
    private String description;
    @OneToMany(mappedBy = "profession")
    @ApiModelProperty(notes = "The List of user of this profession")
    private List<User> users;
    @ManyToOne
    @ApiModelProperty(notes = "The category of this profession")
    private Category category;

}
