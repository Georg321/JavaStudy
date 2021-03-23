package com.example.demo.api;

import com.example.demo.api.entity.DTO;
import com.example.demo.api.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    @Autowired
    private Converter converter;
    private DTO myDto;

    public ResponseEntity<DTO> getDto(){
        if(myDto==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(myDto, HttpStatus.OK);
    }

    public MicroserviseBaseResponse saveDto(String name, String description){
        if(myDto == null){
            myDto = new DTO(name, description);
            return new MicroserviseBaseResponse(true, null, 200);
        }
        return new MicroserviseBaseResponse(false, "already exist", 409);
    }

    public MicroserviseBaseResponse saveDtoFromItem(Item item){
        if(myDto == null){
            myDto = converter.toDTO(item);
            return new MicroserviseBaseResponse(true, null, 200);
        }
        return new MicroserviseBaseResponse(false, "already exist", 409);
    }
}
