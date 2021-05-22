package com.stockmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.domain.StocksManager;

@Repository
public interface StocksManagerRepository extends JpaRepository<StocksManager, String>{

}
