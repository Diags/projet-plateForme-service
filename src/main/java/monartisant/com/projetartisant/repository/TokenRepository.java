package monartisant.com.projetartisant.repository;

import monartisant.com.projetartisant.model.Token;
import monartisant.com.projetartisant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@RepositoryRestResource
public interface TokenRepository extends JpaRepository<Token,Long> {
    Token findByTransitToken(String token);
    Token findByUser(User user);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Token t SET t.transitToken = :transitToken WHERE  t.id = :id")
    void setTransitToken(@Param("transitToken") String transitToken, @Param("id") Long id);

}
