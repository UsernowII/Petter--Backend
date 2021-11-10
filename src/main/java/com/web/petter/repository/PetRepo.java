package com.web.petter.repository;

import com.web.petter.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends MongoRepository<Pet,Integer> {


}
