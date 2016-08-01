package com.arolla.domain;


public class Withdraw extends Movement {

	public Withdraw(Money amount) {
		super(amount);
	}

	public Money getAmount() {
		return amount.negate();
	}

}
