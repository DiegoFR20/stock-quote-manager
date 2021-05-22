package com.stockquotemanager.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stockquotemanager.domain.Stocks;
import com.stockquotemanager.service.StocksService;

@RestController
@RequestMapping(path="/stocks")
public class StocksResource {
	
	@Autowired
	private StocksService stockservice;
	
	@GetMapping
	public ResponseEntity<List<Stocks>> findAll(){
		return ResponseEntity.ok().body(stockservice.findAll());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Stocks> findById(@PathVariable String id) throws Exception{
		return ResponseEntity.ok().body((Stocks) stockservice.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Stocks> create(@RequestBody Stocks stocks) throws Exception{
		stocks = stockservice.create(stocks);
		
		if (verifyStock(stocks.getId()))
			throw new Exception();
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(stocks.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	private boolean verifyStock(String id) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			return restTemplate.getForObject(
					"http://localhost:8080/stocks{id}", 
					Boolean.class);
		} catch (Exception e) {
			throw new Exception();
		}
	}
}
