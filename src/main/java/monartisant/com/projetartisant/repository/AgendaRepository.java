package monartisant.com.projetartisant.repository;

import monartisant.com.projetartisant.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AgendaRepository  extends JpaRepository<Agenda, Long> {
}
