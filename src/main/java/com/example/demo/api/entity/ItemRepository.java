package com.example.demo.api.entity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<ItemEntity, String> {
}
