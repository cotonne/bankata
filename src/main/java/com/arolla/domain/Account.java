package com.arolla.domain;

import java.util.ArrayList;
import java.util.List;

import com.arolla.domain.exception.InsufficientlyProvisionnedAccountException;

public class Account {
	private List<Movement> movements;
	public Account(Money initialDeposit) {
		movements = new ArrayList<Movement>();
		deposit(initialDeposit);
	}

	public void deposit(Money amount) {
		movements.add(new Deposit(amount));
	}

	public void withdraw(Money amount) {
		assertAccountSufficientlyProvisionned(amount);
		movements.add(new Withdraw(amount));
	}

	private void assertAccountSufficientlyProvisionned(Money amount) {
		if(getBalance().isStriclyLessThan(amount))
			throw new InsufficientlyProvisionnedAccountException();
	}
	
	public Money getBalance() {
		return movements.stream()
				.map(Movement::getAmount)
				.reduce(Money::add)
				.get();
	}
}
