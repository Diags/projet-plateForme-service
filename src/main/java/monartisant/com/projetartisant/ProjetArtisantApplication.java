package monartisant.com.projetartisant;

import monartisant.com.projetartisant.model.*;
import monartisant.com.projetartisant.repository.*;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@SpringBootApplication
public class ProjetArtisantApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AdresRepository adresRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    private ImageRepository imageRepository;


    public static void main(String[] args) {
        SpringApplication.run(ProjetArtisantApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(User.class, Category.class, Adresse.class, Token.class);
      //  Adresse a = new Adresse(null, 12, "rue", "emeraude", 69006, "lyon");
        Random rd = new Random();
        categoryRepository.save(new Category(null, "BATIMENT", RandomString.make(12), "batima", null));
        categoryRepository.save(new Category(null, "FABRICATION", RandomString.make(12), "meunuisier", null));
        categoryRepository.save(new Category(null, "ALIMENTATION", RandomString.make(12), "restau", null));
        categoryRepository.save(new Category(null, "TRANSPORT", RandomString.make(12), "tran1", null));
        categoryRepository.save(new Category(null, "EDUCATION", RandomString.make(12), "education", null));
        categoryRepository.save(new Category(null, "HAUTE COUTURE", RandomString.make(12), "couturier", null));
        categoryRepository.save(new Category(null, "SERVICES", RandomString.make(12), "doctor", null));
        ArrayList<String> mylist = new ArrayList<String>();
        mylist.add("barack");
        mylist.add("ba");
        ArrayList<String> mylist1 = new ArrayList<String>();
        mylist1.add("Lyon");
        mylist1.add("Dijon");
        mylist1.add("Paris");
        mylist1.add("Marseil");
        mylist1.add("Bordeau");
        mylist1.add("Nante");
        mylist1.add("Stranbourgue");
        mylist1.add("Toulouse");
        categoryRepository.findAll().forEach(c -> {
            for (int i = 0; i < 10; i++) {
                User user = new User();
                Adresse adresse = new Adresse();
                adresse.setNumeroRue(1 + rd.nextInt(100));
                adresse.setRue("rue");
                adresse.setName("emeraude");
                adresse.setCodePostal(10 + rd.nextInt(20018));
                Collections.shuffle(mylist1, new Random());
                adresse.setVille(mylist1.get(0));
                user.setNom(RandomString.make(8));
                user.setPrenom(RandomString.make(9));
                user.setAge(1988 + rd.nextInt(20018));
                user.isBanned();
                user.setNumeroSiret(100001988 + rd.nextInt(1000020018));
             //   user.setAdresse(new Adresse(null, 1 + rd.nextInt(100), "rue", "emeraude", 10 + rd.nextInt(20018), "lyon"));
                Collections.shuffle(mylist, new Random());
                user.setPhotoName(mylist.get(0));
                user.setAdresse(adresse);
                user.setCategory(c);

                userRepository.save(user);
            }
        });
    }

}
