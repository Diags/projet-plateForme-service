package monartisant.com.projetartisant.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor @NoArgsConstructor
public class MapData {
    private String paysName;
    private  String ville;
}
