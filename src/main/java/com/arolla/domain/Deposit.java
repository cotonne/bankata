package com.arolla.domain;


public class Deposit extends Movement {

	public Deposit(Money amount) {
		super(amount);
	}

	public Money getAmount() {
		return amount;
	}
}
