package monartisant.com.projetartisant.repository;

import monartisant.com.projetartisant.model.Adresse;
import monartisant.com.projetartisant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AdresRepository extends JpaRepository<Adresse,Long> {
List<User> findByAndVilleContainsAndCodePostalContains(String ville, int codePostal);
}






