package com.example.cats_api.service;

import com.example.cats_api.dto.CatDto;
import com.example.cats_api.entity.Cat;
import com.example.cats_api.mapper.CatMapper;
import com.example.cats_api.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatService {
    private final CatRepository catRepository;
    private final CatMapper catMapper;


    @Transactional
    public CatDto save(CatDto catDto){
        catRepository.save(catMapper.toCat(catDto));
        Cat cat = catRepository.findAll().get(0);

        return catMapper.fromCat(cat);
    }

    public Iterable<CatDto> getAll(){
        return catRepository.findAll()
                .stream()
                .map(catMapper::fromCat)
                .collect(Collectors.toList());
    }
}
