package com.example.demo.api.entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<ItemEntity, String> {
    @Query(value = "{ 'name' : ?0}", sort = "{ 'created' : -1 }")
    List<ItemEntity> findAllByName(String name);
}
