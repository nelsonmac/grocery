package com.ir.grocery.repository;

import com.ir.grocery.models.PriceHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PriceHistoryRepository extends MongoRepository<PriceHistory, String> {

}
