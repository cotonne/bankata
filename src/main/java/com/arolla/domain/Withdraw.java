package com.arolla.domain;

public class Withdraw implements Movement {

	private final Money amount;

	public Withdraw(Money amount) {
		this.amount = amount.negate();
	}

	public Money getAmount() {
		return amount;
	}

}
