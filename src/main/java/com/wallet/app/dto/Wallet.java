package com.wallet.app.dto;

import java.time.LocalDate;

public class Wallet {
	private Integer id;
	private String password;
	private Double balance;
	private String name;
	private LocalDate creationDate;

	public Wallet() {
		super();
		this.creationDate = LocalDate.now();
	}

	public Wallet(Integer id, String name, Double balance, String password, LocalDate creationDate) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.password = password;
		this.creationDate = LocalDate.now();
	}

	public Integer getId() {
		return id;
	}

	/*
	 * public void setId(Integer id) { this.id = id; }
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	@Override
	public String toString() {
		return "Wallet id=" + id + ", name=" + name + ", balance=" + balance + ", password=" + password
				+ ", creationDate=" + creationDate ;
	}

	/*
	 * public void setCreationDate(LocalDate creationDate) { this.creationDate =
	 * creationDate; }
	 */
	
	

}