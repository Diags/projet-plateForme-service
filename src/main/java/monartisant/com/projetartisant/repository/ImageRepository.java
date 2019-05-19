package monartisant.com.projetartisant.repository;

import monartisant.com.projetartisant.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ImageRepository  extends JpaRepository<Image, Long> {
}
