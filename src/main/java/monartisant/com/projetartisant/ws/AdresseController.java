package monartisant.com.projetartisant.ws;

import monartisant.com.projetartisant.repository.AdresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin("*")
@RestController
public class AdresseController {
    @Autowired
    private AdresRepository  adresRepository;

    @GetMapping("villes/{paysName}")
    public List<String>getVillesByPays(@RequestParam("paysName") String paysName){
        return adresRepository.findByPays(paysName).stream().map(a -> a.getVille().toUpperCase()).distinct().collect(Collectors.toList());
    }

//    @GetMapping("pays")
//    public List<String>getPays(){
////        return adresRepository.findAll().stream().map(a -> a.getPays().toUpperCase()).distinct().collect(Collectors.toList());
//    }
}
