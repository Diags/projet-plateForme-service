package monartisant.com.projetartisant.ws;

import monartisant.com.projetartisant.model.User;
import monartisant.com.projetartisant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(path = "photouser/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getUserPhoto(@PathVariable("id") Long id) throws Exception {
         User user = userRepository.findById(id).get();
       return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Desktop/imageDiaguily/image/"+user.getPhotoName()+".png"));

    }
}
