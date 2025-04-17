package org.example.app.registration;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/registrations")
public class RegistryController {

    private final RegistrationRepository registrationRepository;

    public RegistryController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public Registration create(@RequestBody @Valid Registration registration) {
        String ticketCode = UUID.randomUUID().toString();
        return registrationRepository.insert(
                new Registration(
                        null,
                        registration.productId(),
                        ticketCode = ticketCode,
                        registration.attendeeName()
                )
        );
    }

    @GetMapping(path = "/{ticketCode}")
    public Registration get(@PathVariable("ticketCode") String ticketCode) {
        return registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration by ticketCode:" + ticketCode + " notFound"));
    }

    @PutMapping
    public Registration update(@RequestBody Registration registration) {
        return registrationRepository.save(registration);
    }

    @DeleteMapping(path = "/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode) {
        registrationRepository.deleteBy(ticketCode);
    }
}
