package monartisant.com.projetartisant.repository;

import monartisant.com.projetartisant.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
