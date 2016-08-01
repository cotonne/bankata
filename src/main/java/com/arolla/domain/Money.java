package com.arolla.domain;

public class Money {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(value);
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (Float.floatToIntBits(value) != Float.floatToIntBits(other.value))
			return false;
		if (currency != other.currency)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Money [amount=" + value + ", currency=" + currency + "]";
	}

	private float value;
	private Currency currency;

	public Money(float value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}

	public Money add(Money amount) {
		return new Money(this.value + amount.value, currency);
	}

	public Money negate() {
		return new Money(-value, currency);
	}

	public boolean isNegative() {
		return value < 0;
	}

	public boolean isStriclyLessThan(Money amount) {
		return value < amount.value;
	}

}
