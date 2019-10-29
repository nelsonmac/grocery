package com.ir.grocery.repository;

import com.ir.grocery.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, String> {

    Users findByEmail(String email);

}
