package org.example.app.events;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizerRepository {
    public List<Organizer> findAll() {
        return List.of();
    }
}
