package com.ir.grocery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ir.grocery.models.MUom;

public interface MUomRepository extends  MongoRepository<MUom, String> {

}
