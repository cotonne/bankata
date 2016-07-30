package com.arolla.domain;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private List<Movement> movements;
	public Account(Money initialDeposit) {
		movements = new ArrayList<Movement>();
		deposit(initialDeposit);
	}

	private void deposit(Money amount) {
		movements.add(new Deposit(amount));
	}

	public void withdraw(Money amount) {
		movements.add(new Withdraw(amount));
	}
	
	public Money getBalance() {
		return movements.stream()
				.map(Movement::getAmount)
				.reduce(Money::add)
				.get();
	}
}
