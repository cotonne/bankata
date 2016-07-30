package com.arolla.domain;

public class Client {
	private String clientName;
	private Account account;
	
	public Client(Builder builder) {
		clientName = builder.clientName;
		account = new Account(builder.initialDeposit);
	}

	public Money getBalance() {
		return account.getBalance();
	}

	public void withdraw(Money amount) {
		account.withdraw(amount);
	}

	public static class Builder {
		private String clientName;
		private Money initialDeposit;
		
		public Builder(){
			
		}
		
		public final Builder withName(String clientName) {
			this.clientName = clientName;
			return this;
		}

		public Builder andInitialDepositOnAccount(Money initialDeposit) {
			this.initialDeposit = initialDeposit;
			return this;
		}

		public Client build() {
			return new Client(this);
		}
		
	}
}
