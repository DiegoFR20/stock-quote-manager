package com.stockmanager.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.domain.StocksManager;
import com.stockmanager.repositories.StocksManagerRepository;

@Service
public class StocksManagerService {
	
	@Autowired
	private StocksManagerRepository repo;

	public StocksManager create(StocksManager stocksmanager) {
		return repo.save(stocksmanager);
	}

	public Object findById(String id) {
		return repo.findById(id).get();
	}

	@SuppressWarnings("unchecked")
	public Set<StocksManager> findAll() {
		return (Set<StocksManager>) repo.findAll();
	}
}
