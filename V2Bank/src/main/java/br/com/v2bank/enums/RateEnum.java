package br.com.v2bank.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum RateEnum {
	
	RATE_MONTH(0.002),
	NEGATIVE_DEPOSIT_RATE(1.005),
	CURRENT_ACCOUNT_RATE(1.0001);

	public Double tax;
}
