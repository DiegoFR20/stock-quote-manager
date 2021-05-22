package com.stockmanager.resource;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stockmanager.domain.Notification;
import com.stockmanager.domain.StocksManager;
import com.stockmanager.service.StocksManagerService;

@RestController
@RequestMapping(path="/stocks")
public class StocksResource {
	Map<String, Set<StocksManager>> stockscache = new HashMap<>();
	
	@Autowired
	private StocksManagerService stocksmanagerservice;
	
	@GetMapping
	public ResponseEntity<Set<StocksManager>> findAll(
			@RequestBody Notification notification){
		StringBuilder client = new StringBuilder().append("localhost:8080");
		
		if (stockscache.isEmpty()) {
			stockscache.put(client.toString(), stocksmanagerservice.findAll());
			return ResponseEntity.ok().body(stockscache.get(client.toString()));
		}
		else {
			return ResponseEntity.ok().body(stockscache.get(client.toString()));
		}
	}
	
	@PostMapping
	public ResponseEntity<StocksManager> create(
			@RequestBody StocksManager stocksmanager) {
		stocksmanager = stocksmanagerservice.create(stocksmanager);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(stocksmanager.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping("/notification")
	public ResponseEntity<Object> postnotification(
			@RequestBody Notification notification){
		StringBuilder client = new StringBuilder()
				.append(notification.getHost())
				.append("-")
				.append(notification.getPort());
		
		stockscache.put(client.toString(), stocksmanagerservice.findAll());
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/stockcache")
	public ResponseEntity<Object> deletenotification(
			@RequestBody Notification notification){
		StringBuilder client = new StringBuilder()
				.append(notification.getHost())
				.append("-")
				.append(notification.getPort());
		
		stockscache.remove(client.toString());
		
		return ResponseEntity.ok().build();
	}
}
