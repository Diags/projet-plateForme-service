package monartisant.com.projetartisant.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class UserAgenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date currenteDate;
    @ElementCollection
    @CollectionTable
    private Collection<Date> slots = new ArrayList<>();
    @OneToOne(mappedBy = "useragenda")
    private User user;
}
