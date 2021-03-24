package com.example.demo.api.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTO {
    private String name;
    private String description;
    private LocalDateTime created;
}
