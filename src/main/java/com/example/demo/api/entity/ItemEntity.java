package com.example.demo.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ItemEntity {   //Сущность для хранения в базе данных
    private String name;
    private String description;
    private LocalDateTime created;
}
