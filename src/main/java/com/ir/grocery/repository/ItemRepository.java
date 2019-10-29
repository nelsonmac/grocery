package com.ir.grocery.repository;

import com.ir.grocery.models.Item;
import com.ir.grocery.models.MCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
