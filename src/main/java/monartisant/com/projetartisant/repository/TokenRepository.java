package monartisant.com.projetartisant.repository;

import monartisant.com.projetartisant.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.annotation.Resource;

@RepositoryRestResource
public interface TokenRepository extends JpaRepository<Token,Long> {
}
