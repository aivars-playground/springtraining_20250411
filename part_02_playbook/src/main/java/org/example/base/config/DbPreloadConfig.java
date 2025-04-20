package org.example.base.config;


import org.example.base.models.one.Contact;
import org.example.base.models.two.User;
import org.example.base.repositories.one.ContactRepository;
import org.example.base.repositories.two.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbPreloadConfig {

    @Bean
    CommandLineRunner initDatabase(ContactRepository repository, UserRepository repositoryTwo) {

        return args -> {
            System.out.println("Preloading " + repository.save(new Contact("John Smith", "123-456-7890", "jo.smith@example.com")));
            System.out.println("Preloading " + repository.save(new Contact("Jane Smith", "098-765-4321", "ja.smith@example.com")));
            System.out.println("Preloading Two " + repositoryTwo.save(new User("User")));
        };
    }
}