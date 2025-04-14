package org.example.app.events;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    public List<Product> findByEventId(int eventId) {
        return List.of();
    }
}
