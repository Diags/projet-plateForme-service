package monartisant.com.projetartisant.ws;

import monartisant.com.projetartisant.model.Category;
import monartisant.com.projetartisant.model.User;
import monartisant.com.projetartisant.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;
@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping(path = "photocategory/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getCategoryPhoto(@PathVariable("id") Long id) throws Exception {
       Category category = categoryRepository.findById(id).get();
       System.out.append(category.getPhoto());
        return Files.readAllBytes( Paths.get(this.getClass().getClassLoader().getResource("imageDiaguily/catalogue/"+category.getPhoto()+".png").toURI()));
       // return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Desktop/imageDiaguily/catalogue/"+category.getPhoto()+".png"));

    }
}