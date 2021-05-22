package com.stockquotemanager.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Quote implements Serializable {
	private static final long serialVersionUID = -5367551885185814523L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String date;
	private String value;

	@ManyToOne
	@JoinColumn(name="stocks_id")
	private Stocks stocks;
	
	public String getDate() {
		return date;
	}
	
	public Stocks getStocks() {
		return stocks;
	}

	public String getValue() {
		return value;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setStocks(Stocks stocks) {
		this.stocks = stocks;
	}

	public void setValue(String value) {
		this.value = value;
	}
}