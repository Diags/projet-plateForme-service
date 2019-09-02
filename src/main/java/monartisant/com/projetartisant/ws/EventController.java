package monartisant.com.projetartisant.ws;

import monartisant.com.projetartisant.model.Event;
import monartisant.com.projetartisant.repository.EventRepository;
import monartisant.com.projetartisant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class EventController {
    @Autowired
    private UserRepository  userRepository;
    @Autowired
    private EventRepository eventRepository;

@PostMapping("/events")
    public List<Event> getAllEvents(@RequestBody Event event) {
        return eventRepository.findAll();
    }
}
