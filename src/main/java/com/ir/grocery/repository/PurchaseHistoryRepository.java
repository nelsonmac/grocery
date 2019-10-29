package com.ir.grocery.repository;

import com.ir.grocery.models.PurchaseHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseHistoryRepository extends MongoRepository<PurchaseHistory , String> {
}
