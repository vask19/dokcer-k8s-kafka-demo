package com.example.cats_api.mapper;


import com.example.cats_api.dto.CatDto;
import com.example.cats_api.entity.Cat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CatMapper {

    public Cat toCat(CatDto catDto){
        return Cat.builder()
                .name(catDto.getName())
                .birthDay(catDto.getBirthDay())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public CatDto fromCat(Cat cat){
        return CatDto.builder()
                .name(cat.getName())
                .birthDay(cat.getBirthDay())
                .build();
    }
}
