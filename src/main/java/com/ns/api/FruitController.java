package com.ns.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {this.fruitService = fruitService;}

    @PostMapping("/fruit")
    public ResponseEntity addFruit(@RequestBody FruitModel fruitModel) {
        log.info("Request : {}", fruitModel);
        fruitService.saveFruit(fruitModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/fruit")
    public List<FruitModel> getAllFruit() {
        return fruitService.findAll();
    }
    
    @GetMapping("/fruit/name/{name}")
    public List<FruitModel> getFruitByName(@PathVariable("name") String name) {
        return fruitService.findByName(name);
    }
    @GetMapping("/fruit/color/{color}")
    public List<FruitModel> getFruitByColor(@PathVariable("color") String color) {
        return fruitService.findByColor(color);
    }
    

    @GetMapping("/fruit/stock/{stock}")
    public List<FruitModel> getFruitwithStock(@PathVariable("stock") int stock) {
    	return fruitService.getFruitwithStock(stock);
    }
    
}
