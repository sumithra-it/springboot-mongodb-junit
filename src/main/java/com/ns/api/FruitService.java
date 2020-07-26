package com.ns.api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {this.fruitRepository = fruitRepository;}

    public FruitModel saveFruit(FruitModel fruitModel) {
        return fruitRepository.save(fruitModel);
    }

    public List<FruitModel> findAll() {
        return fruitRepository.findAll();
    }
    
    public List<FruitModel> findByName(String name) {
    	return fruitRepository.findByName(name);
    }
    
    public List<FruitModel> findByColor(String color) {
    	return fruitRepository.findByColor(color);
    }
    
    public List<FruitModel> getFruitwithStock(int stock) {
    	return fruitRepository.getFruitwithStock(stock);
    }
}
