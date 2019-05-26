package monartisant.com.projetartisant.ws;

import monartisant.com.projetartisant.model.Profession;
import monartisant.com.projetartisant.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;
@CrossOrigin("*")
@RestController
public class ProfessionController {
    @Autowired
    private ProfessionRepository professionRepository;
    @GetMapping(path = "photoprofession/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getProfessionPhoto(@PathVariable("id") Long id) throws Exception {
        Profession profession = professionRepository.findById(id).get();
        return Files.readAllBytes( Paths.get(this.getClass().getClassLoader().getResource("imageDiaguily/profession/"+profession.getPhoto()+".png").toURI()));
    }

}
