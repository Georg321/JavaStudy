package com.example.demo.api;

import com.example.demo.api.entity.DTO;
import com.example.demo.api.entity.Item;
import com.example.demo.api.entity.ItemEntity;
import com.example.demo.api.entity.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class MyComponent {
    @Autowired
    private Converter converter;
    @Autowired
    private ItemRepository itemRepository;  //Интерфейс для работы с бд

    @Value("${host}")
    String host;

    @PostConstruct
    void init(){
        List<ItemEntity> list = itemRepository.findAllByName("Robert3");
        double a = 0.0;
    }


    public ResponseEntity<DTO> getFirstDto(){
        /*Поскольку мы теперь работаем с бд, мы получаем сразу много сущностей, если не ищем по MongoID,
        а конструкция ".findAll().stream().findFirst()" берет первый попавшийся элемент.
        Но может быть такое, что в бд пусто и она не сможет нам вернуть запрашиваемые данные. В таком случае
        база вернет нам "пусто". Это достигается с помощью обертки Optional<> :
         */
        Optional<ItemEntity> dtoOptional = itemRepository.findAll().stream().findFirst();

        if(dtoOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        /* с помощью dtoOptional.get() разворачиваем нашу обертку и получаем лежащую в ней ItemEntity, которую
        конвертируем в дто*/
        return new ResponseEntity<>(converter.toDTO(dtoOptional.get()), HttpStatus.OK);
    }

    public MicroserviseBaseResponse saveDto(String name, String description){
        Item item = new Item(name, description);
        itemRepository.save(converter.toEntity(item, LocalDateTime.now()));

        return new MicroserviseBaseResponse(true, null, 201);
    }

    public MicroserviseBaseResponse saveDtoFromItem(Item item){
        itemRepository.save(converter.toEntity(item, LocalDateTime.now()));

        return new MicroserviseBaseResponse(true, null, 201);
    }

    public MicroserviseBaseResponse deleteItems(){
        if(itemRepository.count() == 0){
            return new MicroserviseBaseResponse(false, "Mistake", 404);
        }

        itemRepository.deleteAll();

        return new MicroserviseBaseResponse(true, null, 201);
    }
}
