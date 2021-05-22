package com.stockquotemanager.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Stocks implements Serializable {
	private static final long serialVersionUID = -2857719712600263764L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	@OneToMany(mappedBy="stocks")
	private List<Quote> quotes = new LinkedList<>();

	public String getId() {
		return id;
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

}
