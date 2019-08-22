package monartisant.com.projetartisant.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Proxy(lazy = false)
public class UserCommentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String createBy;
    @ElementCollection
    @CollectionTable
    private Collection<String> commentaire = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private User user ;
}
