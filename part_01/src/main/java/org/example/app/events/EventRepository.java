package org.example.app.events;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EventRepository {

    public List<Event> findByOrganizerId(int organizerId) {
        return List.of();
    }

    public Optional<Event> findById(int eventId) {
        return Optional.empty();
    }
}
