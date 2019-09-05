package monartisant.com.projetartisant.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import monartisant.com.projetartisant.model.Event;

@Data @AllArgsConstructor @NoArgsConstructor
public class SearchEvents {
    private Long userId;
    private Event event;
}
