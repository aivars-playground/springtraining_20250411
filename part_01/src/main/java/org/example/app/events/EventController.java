package org.example.app.events;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EventController {

    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;
    private final ProductRepository productRepository;

    public EventController(OrganizerRepository organizerRepository, EventRepository eventRepository, ProductRepository productRepository) {
        this.organizerRepository = organizerRepository;
        this.eventRepository = eventRepository;
        this.productRepository = productRepository;
    }

    public List<Organizer> getOrganizers() {
        return organizerRepository.findAll();
    }
}
