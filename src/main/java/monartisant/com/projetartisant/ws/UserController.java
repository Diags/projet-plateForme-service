package monartisant.com.projetartisant.ws;

import monartisant.com.projetartisant.model.User;
import monartisant.com.projetartisant.repository.AdresRepository;
import monartisant.com.projetartisant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdresRepository adresRepository;
    @GetMapping(path = "photouser/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getUserPhoto(@PathVariable("id") Long id) throws Exception {
         User user = userRepository.findById(id).get();
       return Files.readAllBytes( Paths.get(this.getClass().getClassLoader().getResource("imageDiaguily/image/"+user.getPhotoName()+".png").toURI()));
    }
    @GetMapping("/usersbyville")
    public List<User> getUserByVille(@RequestBody SearchParam param){
        return adresRepository.findByAndVilleContainsAndCodePostalContains(param.getVille(), param.getCodePostale());
    }
    @PutMapping("user/{rating}")
    public void update(@RequestBody SearchParamNote param, Long id){
         userRepository.updateNote(param.getNote(), param.getId());
    }
    @PutMapping("search")
    public void search(@RequestBody SendUserInfosToPro param, Long id){

    }

}
