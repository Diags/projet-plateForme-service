package monartisant.com.projetartisant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tokenTransit;
    private Date expiredDate;
    private Date lastCreate;
    private Date lastModify;
    @OneToOne(cascade= CascadeType.ALL)
    private User user;
}
