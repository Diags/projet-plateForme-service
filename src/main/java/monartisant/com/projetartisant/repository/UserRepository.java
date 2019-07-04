package monartisant.com.projetartisant.repository;

import monartisant.com.projetartisant.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("update  User u   set u.note = note  where  u.id =id")
    User updateNote(Double note, Long id);

    @Query("select u from User u  where  u.profession.name =:name and u.adresse.ville =:ville")
    List<User> getUsers(@Param("name") String name, @Param("ville") String ville);
    // List<User> findByprofession_nameContainsAndAdresse_villeContainsAndProfession_Category_name(String professionName, String ville, String categoryName);

    @Query("select u from User u")
    List<User> chercherUsers(Pageable pageable);

    List<User> findByAdresse_Pays_nameAndAdresse_ville(String paysName, String ville);

//    User findByemailAndpassword(String email, String password);

//    User findByemail(String email);
}
