package org.example.app.registration;

import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/registrations")
public class RegistryController {

    private final RegistrationRepository registrationRepository;

    public RegistryController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public Registration create(@RequestBody Registration registration) {
        return registrationRepository.create(registration);
    }

    @GetMapping(path = "/{ticketCode}")
    public Registration get(@PathVariable("ticketCode") String ticketCode) {
        return registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration by ticketCode:" + ticketCode + " notFound"));
    }

    @PutMapping
    public Registration update(@RequestBody Registration registration) {
        return registrationRepository.update(registration);
    }

    @DeleteMapping(path = "/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode) {
        registrationRepository.deleteBy(ticketCode);
    }
}
