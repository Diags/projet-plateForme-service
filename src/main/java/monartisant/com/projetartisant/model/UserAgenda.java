package monartisant.com.projetartisant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class UserAgenda {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Date currentDate;
    @ElementCollection
    @CollectionTable(name = "userAgenda_slots", joinColumns = @JoinColumn(name = "userAgendaId"))
    @Column(name = "slots")
    private List<Date> slots = new ArrayList<>();
}
