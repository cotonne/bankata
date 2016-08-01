package com.arolla.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.arolla.domain.Account;
import com.arolla.domain.Currency;
import com.arolla.domain.Money;
import com.arolla.domain.exception.InsufficientlyProvisionnedAccountException;

public class AccountTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void should_withdraw_the_good_amount() {
		Account account = new Account(new Money(100.0f, Currency.EURO));
		account.withdraw(new Money(10.0f, Currency.EURO));
		assertEquals("The final balance should have been 90 euro", new Money(90.0f, Currency.EURO), account.getBalance());
	}
	
	@Test(expected=InsufficientlyProvisionnedAccountException.class)
	public void should_refuse_a_withdraw_if_account_is_empty() {
		Account account = new Account(new Money(1.0f, Currency.EURO));
		account.withdraw(new Money(10.0f, Currency.EURO));
	}
}
