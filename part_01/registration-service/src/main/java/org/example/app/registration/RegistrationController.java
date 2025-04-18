package org.example.app.registration;

import jakarta.validation.Valid;
import org.example.app.events.Event;
import org.example.app.events.EventsClient;
import org.example.app.events.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/registrations")
public class RegistrationController {

    private final RegistrationRepository registrationRepository;
    private final EventsClient eventsClient;

    public RegistrationController(RegistrationRepository registrationRepository, EventsClient eventsClient) {
        this.registrationRepository = registrationRepository;
        this.eventsClient = eventsClient;
    }

    @PostMapping
    public Registration create(@RequestBody @Valid Registration registration) {

        String ticketCode = UUID.randomUUID().toString();
        Product product = eventsClient.getProductById(registration.productId());
        Event event = eventsClient.getEventsById(product.eventId());

        var registrationToSave = new Registration(
                null,
                registration.productId(),
                event.name(),
                product.price(),
                ticketCode,
                registration.attendeeName()
        );

        return registrationRepository.save(registrationToSave);
    }

    @GetMapping(path = "/{ticketCode}")
    public Registration get(@PathVariable("ticketCode") String ticketCode) {
        return registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticket code " + ticketCode + " not found"));
    }

    @PutMapping
    public Registration update(@RequestBody Registration registration) {
        // Lookup the existing registration by ticket code
        String ticketCode = registration.ticketCode();
        var existing = registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticket code " + ticketCode + " not found"));

        // Only update the attendee name
        var registrationToSave = new Registration(
                existing.id(),
                existing.productId(),
                existing.eventName(),
                existing.amount(),
                existing.ticketCode(),
                registration.attendeeName()
        );
        return registrationRepository.save(registrationToSave);
    }

    @DeleteMapping(path = "/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode) {
        registrationRepository.deleteByTicketCode(ticketCode);
    }
}
