package monartisant.com.projetartisant.repository;

import monartisant.com.projetartisant.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdresRepository extends JpaRepository<Adresse,Long> {

}






