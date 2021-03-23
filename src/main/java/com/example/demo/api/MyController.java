package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/my-controller")
public class MyController {
    @Autowired
    private Converter converter;
    private DTO myDto;

    @GetMapping("/get-dto")
    public ResponseEntity<DTO> getDto(){
        if(myDto==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(myDto, HttpStatus.OK);
    }

    @PostMapping("/post-dto/{name}/{description}")
    public MicroserviseBaseResponse saveDto(@PathVariable String name, @PathVariable String description){
        if(myDto == null){
            myDto = new DTO(name, description);
            return new MicroserviseBaseResponse(true, null, 200);
        }
            return new MicroserviseBaseResponse(false, "already exist", 409);
    }

    @PostMapping("/post-dto-1")
    public MicroserviseBaseResponse saveDto1(@RequestParam String name, @RequestParam String description){
        if(myDto == null){
            myDto = new DTO(name, description);
            return new MicroserviseBaseResponse(true, null, 200);
        }
        return new MicroserviseBaseResponse(false, "already exist", 409);
    }

    @PostMapping("/post-dto-2")
    public MicroserviseBaseResponse saveDto2(@RequestBody Item item){
        if(myDto == null){
            myDto = converter.toDTO(item);
            return new MicroserviseBaseResponse(true, null, 200);
        }
        return new MicroserviseBaseResponse(false, "already exist", 409);
    }
}
