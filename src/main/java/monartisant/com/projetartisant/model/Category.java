package monartisant.com.projetartisant.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated profession ID")
    private Long id;
    @ApiModelProperty(notes = "The name of profession")
    private String name;
    @ApiModelProperty(notes = "The  profession description")
    private String description;
    @ApiModelProperty(notes = "The  image url name of category")
    private String photo;
    @OneToMany(mappedBy = "category")
    @ApiModelProperty(notes = "The collection of professions")
    private Collection<Profession> professions;
}
