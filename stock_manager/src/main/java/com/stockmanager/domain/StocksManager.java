package com.stockmanager.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StocksManager implements Serializable {
	private static final long serialVersionUID = -5642885251381615431L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String description;

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
