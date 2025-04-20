package org.example.base.repositories.two;


import org.example.base.models.two.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
