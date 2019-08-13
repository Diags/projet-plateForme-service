package monartisant.com.projetartisant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tokenTransit;
    private Date expiredDate;
    private Date lastCreate;
    private Date lastModify;
    @OneToOne(fetch = FetchType.EAGER, cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    private User user;
}
