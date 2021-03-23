package com.example.demo.api;

import com.example.demo.api.entity.DTO;
import com.example.demo.api.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    public DTO toDTO(Item item){
        return new DTO(item.getName2(), item.getDescription());
    }
}
