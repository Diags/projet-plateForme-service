package monartisant.com.projetartisant.repository;

import monartisant.com.projetartisant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Long> {
    @Modifying(clearAutomatically = true)
    @Query("update  User u   set u.note =: note  where  c.id =: id")
    default void updateNote(@Param("note") Double note, Long id) {

    }
}
