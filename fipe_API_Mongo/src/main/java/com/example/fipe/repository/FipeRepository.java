package com.example.fipe.repository;

import com.example.fipe.model.FipeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FipeRepository extends MongoRepository<FipeEntity,String> {

}
