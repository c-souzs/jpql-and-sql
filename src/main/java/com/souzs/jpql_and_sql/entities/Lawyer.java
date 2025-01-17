package com.souzs.jpql_and_sql.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "lawyers")
public class Lawyer {

	@Id
	private Long register;
	private String name;
	private Integer customersNumber;
	
	public Lawyer() {
	}

	public Long getRegister() {
		return register;
	}

	public void setRegister(Long register) {
		this.register = register;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCustomersNumber() {
		return customersNumber;
	}

	public void setCustomersNumber(Integer customersNumber) {
		this.customersNumber = customersNumber;
	}
}
