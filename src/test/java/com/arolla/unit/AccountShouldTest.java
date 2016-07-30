package com.arolla.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.arolla.domain.Account;
import com.arolla.domain.Currency;
import com.arolla.domain.Money;

public class AccountShouldTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void withdraw_the_good_amount() {
		Account account = new Account(new Money(100.0f, Currency.EURO));
		account.withdraw(new Money(10.0f, Currency.EURO));
		assertEquals("The final balance is invalid", new Money(90.0f, Currency.EURO), account.getBalance());
	}

}
