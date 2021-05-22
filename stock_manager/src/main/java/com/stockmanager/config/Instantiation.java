package com.stockmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.stockmanager.domain.StocksManager;
import com.stockmanager.service.StocksManagerService;

@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	private StocksManagerService stmanagerservice;
	
	@Override
	public void run(String... args) {
		StocksManager petr = new StocksManager();
		petr.setId("petr3");
		petr.setDescription("test petr");
		
		StocksManager vale = new StocksManager();
		petr.setId("vale5");
		petr.setDescription("test vale");
		
		stmanagerservice.create(petr);
		stmanagerservice.create(vale);
	}
}
