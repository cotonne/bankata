package com.arolla.domain;

import com.arolla.domain.exception.IllegalAmountException;

public abstract class Movement {
	protected final Money amount;

	public Movement(Money amount) {
		validate(amount);
		this.amount = amount;
	}

	abstract Money getAmount();

	public void validate(Money amount) {
		if (amount.isNegative())
			throw new IllegalAmountException();
	}

}
