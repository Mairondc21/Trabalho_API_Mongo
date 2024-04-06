package com.example.clima.repository;

import com.example.clima.model.ClimaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimaRepository extends MongoRepository<ClimaEntity,String> {
}
