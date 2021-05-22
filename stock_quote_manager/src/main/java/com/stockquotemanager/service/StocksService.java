package com.stockquotemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockquotemanager.domain.Stocks;
import com.stockquotemanager.repositories.StocksRepository;

@Service
public class StocksService {

	@Autowired
	private StocksRepository repo;

	public Stocks create(Stocks stocks) {
		return repo.save(stocks);
	}

	public Object findById(String id) {
		return repo.findById(id).get();
	}

	public List<Stocks> findAll() {
		return repo.findAll();
	}
}
