package org.example.base.config;

import org.example.base.models.one.Contact;
import org.example.base.models.two.User;
import org.example.base.repositories.one.ContactRepository;
import org.example.base.repositories.two.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class DbTestPreloadConfig {

    @Bean
    CommandLineRunner initDatabase(ContactRepository repository, UserRepository repositoryTwo) {

        return args -> {
            System.out.println("Preloading TEST data  " + repository.save(new Contact("TEST1", "123-456-7890", "jo.smith@example.com")));
            System.out.println("Preloading TEST data  " + repository.save(new Contact("TEST2", "123-456-7890", "jo.smith@example.com")));
            System.out.println("Preloading TEST data  " + repositoryTwo.save(new User("TESTUSER")));
        };
    }
}
