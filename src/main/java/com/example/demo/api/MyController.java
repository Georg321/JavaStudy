package com.example.demo.api;

import com.example.demo.api.entity.DTO;
import com.example.demo.api.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/my-controller")
public class MyController {
    @Autowired
    private MyComponent myComponent;

    @GetMapping("/get-dto")
    public ResponseEntity<DTO> getDto(){
        return myComponent.getFirstDto();
    }

    @PostMapping("/post-dto/{name}/{description}")
    public MicroserviseBaseResponse saveDto(@PathVariable String name, @PathVariable String description){
        return myComponent.saveDto(name, description);
    }

    @PostMapping("/post-dto-params")
    public MicroserviseBaseResponse saveDto1(@RequestParam String name, @RequestParam String description){
        return myComponent.saveDto(name, description);
    }

    @PostMapping("/post-dto-body")
    public MicroserviseBaseResponse saveDto2(@RequestBody Item item){
        return myComponent.saveDtoFromItem(item);
    }

    @DeleteMapping("/delete-dto")
    public MicroserviseBaseResponse deleteDto(){
        return myComponent.deleteItems();
    }
}
