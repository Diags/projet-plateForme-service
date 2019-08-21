package monartisant.com.projetartisant.repository;

import monartisant.com.projetartisant.model.UserCommentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentaireRepository extends JpaRepository<UserCommentaire, Long> {
}
