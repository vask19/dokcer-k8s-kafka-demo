package com.example.cats_api.controller;

import com.example.cats_api.dto.CatDto;
import com.example.cats_api.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cats")
@RequiredArgsConstructor
public class CatController {
    private final CatService catService;

    @PostMapping
    public CatDto save(@RequestBody CatDto catDto){

        return catService.save(catDto);
    }

    @GetMapping
    public Iterable<CatDto> getAll(){
        return catService.getAll();
    }
}

