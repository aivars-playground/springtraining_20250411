package org.example.app.events;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EventController {

    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;
    private final ProductRepository productRepository;

    public EventController(OrganizerRepository organizerRepository, EventRepository eventRepository, ProductRepository productRepository) {
        this.organizerRepository = organizerRepository;
        this.eventRepository = eventRepository;
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/organizers")
    public List<Organizer> getOrganizers() {
        return organizerRepository.findAll();
    }

    @GetMapping(path = "/events")
    public List<Event> getEventsByOrganizerId(@RequestParam("organizerId") int organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    @GetMapping(path = "/events/{eventId}")
    public Event getEventById(@PathVariable("eventId") int eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new NoSuchElementException("element by id:" + eventId + " notFound"));
    }

    @GetMapping(path = "/products")
    public List<Product> getProductsByEventId(@RequestParam("eventId") int eventId) {
        return productRepository.findByEventId(eventId);
    }
}
