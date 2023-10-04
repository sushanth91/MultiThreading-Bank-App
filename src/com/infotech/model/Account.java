package com.infotech.model;

public class Account {
	private int balance = 2000;

	public int getBalance() {
		return balance;
	}
	public void withdraw(int amount) {
		balance = balance - amount;
	}
	
	public void addBalance(int amount) {
		balance = balance + amount;
	}
}