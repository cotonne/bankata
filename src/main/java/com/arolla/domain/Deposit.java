package com.arolla.domain;

public class Deposit implements Movement {

	private final Money amount;

	public Deposit(Money amount) {
		this.amount = amount;
	}

	public Money getAmount() {
		return amount;
	}
}
