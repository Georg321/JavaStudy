package com.example.demo.api;

import org.springframework.stereotype.Component;

@Component
public class Converter {
    public DTO toDTO(Item item){
        return new DTO(item.getName2(), item.getDescription());
    }
}
