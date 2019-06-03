package monartisant.com.projetartisant.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import monartisant.com.projetartisant.model.Category;
import org.springframework.stereotype.Service;

@Service
@Data @AllArgsConstructor
public class CategoryService {
    public Category getCategory() {
        return new Category(1L, "IMMOBILIER", "this is description", "batima", null);
    }

}