package monartisant.com.projetartisant.repository;

import monartisant.com.projetartisant.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
