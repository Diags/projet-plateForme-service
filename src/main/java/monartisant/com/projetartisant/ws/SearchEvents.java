package monartisant.com.projetartisant.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class SearchEvents {
    private Long eventId;
    private Long userId;
}
