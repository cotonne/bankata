package com.arolla.unit;

import org.junit.Test;

import com.arolla.domain.Currency;
import com.arolla.domain.Deposit;
import com.arolla.domain.Money;
import com.arolla.domain.Withdraw;
import com.arolla.domain.exception.IllegalAmountException;

public class MovementTest {

	@Test(expected=IllegalAmountException.class)
	public void withdraw_should_not_accept_a_negative_amount() {
		new Withdraw(new Money(-10, Currency.EURO));
	}
	
	@Test(expected=IllegalAmountException.class)
	public void deposit_should_not_accept_a_negative_amount() {
		new Deposit(new Money(-10, Currency.EURO));
	}

}
