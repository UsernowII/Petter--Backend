package com.web.petter.repository;

import com.web.petter.model.Consolidated;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsolidatedRepo extends MongoRepository<Consolidated, Integer> {




}
