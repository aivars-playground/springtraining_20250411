package org.example.base.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleEntityRepo extends JpaRepository<ExampleEntity, Long> {
    @Override
    ExampleEntity save(ExampleEntity entity);
}
