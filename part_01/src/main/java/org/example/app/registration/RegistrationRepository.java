package org.example.app.registration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends MongoRepository<Registration, String> {
    Optional<Registration> findByTicketCode(String ticketCode);
    void deleteBy(String ticketCode);
}
