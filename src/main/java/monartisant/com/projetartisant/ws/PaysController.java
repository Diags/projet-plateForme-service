package monartisant.com.projetartisant.ws;

import monartisant.com.projetartisant.model.Pays;
import monartisant.com.projetartisant.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class PaysController {
    @Autowired
    private PaysRepository paysRepository;

    @GetMapping("pays/{paysName}")
    public Pays getPays(@RequestParam("paysName") String paysName){
        return paysRepository.findByName(paysName);
    }
}
