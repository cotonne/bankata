package com.arolla.functionnal;

import static org.junit.Assert.assertEquals;

import com.arolla.domain.Client;
import com.arolla.domain.Currency;
import com.arolla.domain.Money;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioWithdrawMoneyFromAccount {
	private Client client;

	@Given("^an existing client named \"([^\"]*)\" with (\\d+\\.\\d+) EUR in his account$")
	public void an_existing_client_named_with_EUR_in_his_account(String clientName, float initialDeposit) throws Throwable {
		client = new Client.Builder()
					.withName(clientName)
					.andInitialDepositOnAccount(new Money(initialDeposit, Currency.EURO))
					.build();
	}

	@When("^he withdraws (\\d+\\.\\d+) EUR from his account$")
	public void he_withdraws_EUR_from_his_account(float amount) throws Throwable {
	    client.withdraw(new Money(amount, Currency.EURO));
	}

	@Then("^the new balance is (\\d+\\.\\d+) EUR$")
	public void the_new_balance_is_EUR(float expectedAmount) throws Throwable {
		assertEquals("The final balance does not reflect the withdrawal", new Money(expectedAmount, Currency.EURO), client.getBalance());
	}
}
