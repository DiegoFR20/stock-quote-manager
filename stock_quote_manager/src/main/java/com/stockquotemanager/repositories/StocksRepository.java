package com.stockquotemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockquotemanager.domain.Stocks;

@Repository
public interface StocksRepository extends JpaRepository<Stocks, String>{

}
