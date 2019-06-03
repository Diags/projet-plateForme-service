package monartisant.com.projetartisant.ws;

import io.swagger.annotations.ApiOperation;
import monartisant.com.projetartisant.model.Category;
import monartisant.com.projetartisant.repository.CategoryRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;
@Component
@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService cat) {
        this.categoryService = cat;
    }

    @GetMapping(path = "photocategory/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getCategoryPhoto(@PathVariable("id") Long id) throws Exception {
        Category category = categoryRepository.findById(id).get();
        System.out.append(category.getPhoto());
        return Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("imageDiaguily/catalogue/" + category.getPhoto() + ".png").toURI()));
        // return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Desktop/imageDiaguily/catalogue/"+category.getPhoto()+".png"));

    }
    @ApiOperation(value = "retreive one for test Category")
    @GetMapping("categorybyid")
    public @ResponseBody Category getCategoryById() {
        return categoryService.getCategory();
    }

    public void setCategoryRepository(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

}