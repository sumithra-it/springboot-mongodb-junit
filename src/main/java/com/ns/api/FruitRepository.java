package com.ns.api;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.data.mongodb.repository.Query;
@Component
public interface FruitRepository extends MongoRepository<FruitModel ,String> {
	public List<FruitModel> findByName(String name);
	public List<FruitModel> findByColor(String color);
	
	@Query("select name, color, stock from fruiModel where stock > :stock")
    public List<FruitModel> getFruitwithStock(int stock);
	
    //Query fruits which are more than 50 in stock
	/*"SELECT m.name model_name, m.description, l.name set_name" +
	"  FROM model m" +
	"  JOIN lego_set l" +
	"  ON m.lego_set = l.id" +
	"  WHERE :age BETWEEN l.min_age and l.max_age")*/
}
