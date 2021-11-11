package com.web.petter.repository;

import com.web.petter.model.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepo extends MongoRepository<Sale, Integer> {
}
