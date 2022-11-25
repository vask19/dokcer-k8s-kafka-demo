package com.example.jokes.controller;

import com.example.jokes.client.ChuckNorrisJokesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jokes")
@RequiredArgsConstructor
public class JokesController {
    private final ChuckNorrisJokesClient client;

    @GetMapping("random")
    public Map<String, String > getRandomJokes(){
        return Map.of("joke",client.getRandomJoke());

    }
}
