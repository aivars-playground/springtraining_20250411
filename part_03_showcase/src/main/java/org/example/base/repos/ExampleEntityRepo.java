package org.example.base.repos;

import org.example.base.entities.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleEntityRepo extends JpaRepository<ExampleEntity, Long> {
    @Override
    ExampleEntity save(ExampleEntity entity);
}
