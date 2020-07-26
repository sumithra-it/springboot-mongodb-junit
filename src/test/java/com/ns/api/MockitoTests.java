package com.ns.api;

import com.ns.api.FruitService;
import com.ns.api.FruitModel;
import java.util.ArrayList;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

@SpringBootTest
public class MockitoTests {
	
	@Mock
	private FruitRepository fruitRepo;
	
	@InjectMocks
	private FruitService fruitService;
	
	List<FruitModel> fruitList;
	
	@BeforeEach
	void setMockOutput() {
		fruitList = new ArrayList<FruitModel>();
		fruitList.add(new FruitModel("bananna", "yellow", "", 2, 23));
		when(fruitRepo.findByName("bananna")).thenReturn(fruitList);
	}
	
	@Test
	void testGet() {
		assertEquals(fruitList, fruitService.findByName("bananna"));
	}
}
