package org.example.app.registration;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RegistrationRepository {
    public Registration create(Registration registration) {
        return null;
    }

    public Optional<Registration> findByTicketCode(String ticketCode) {
        return Optional.empty();
    }


    public Registration update(Registration registration) {
        return null;
    }

    public void deleteBy(String ticketCode) {
    }
}
