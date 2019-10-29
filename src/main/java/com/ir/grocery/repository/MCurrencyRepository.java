package com.ir.grocery.repository;

import com.ir.grocery.models.MCurrency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MCurrencyRepository extends  MongoRepository<MCurrency, String> {

}
