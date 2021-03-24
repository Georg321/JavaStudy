package com.example.demo.api;

import com.example.demo.api.entity.DTO;
import com.example.demo.api.entity.Item;
import com.example.demo.api.entity.ItemEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class Converter {
    public DTO toDTO(ItemEntity item) {
        return new DTO(item.getName(), item.getDescription(), item.getCreated());
    }

    public ItemEntity toEntity(Item item, LocalDateTime created){
        return new ItemEntity(item.getName(), item.getDescription(), created);
    }
}
