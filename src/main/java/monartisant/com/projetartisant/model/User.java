package monartisant.com.projetartisant.model;


import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "The database generated user ID")
    private Long id;
    @ApiModelProperty(notes = "the user name")
    private String nom;
    @ApiModelProperty(notes = "the user LastName")
    private String prenom;
    @ApiModelProperty(notes = "the user age")
    private int age;
    @ApiModelProperty(notes = "Is this user is banned")
    private boolean isBanned;
    @ApiModelProperty(notes = "the user num of society")
    private int numeroSiret;
    @OneToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "the user adress")
    private Adresse adresse;
    @ApiModelProperty(notes = "the user image url name")
    private String photoName;
    @ApiModelProperty(notes = "is user recommended")
    private String recommanderBy;
    @ManyToOne
    @ApiModelProperty(notes = "the user profession")
    private Profession profession;
    @ApiModelProperty(notes = "the user rating")
    private Double  note ;
    @ApiModelProperty(notes = "the user phone number")
    private Integer tele;
}
