package com.souzs.jpql_and_sql.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

	@Id
	private Long id;
	private String name;
	private Integer amount;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "id_providers")
	private Provider provider;

	@ManyToOne
	@JoinColumn(name = "id_categories")
	private Category category;

	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
