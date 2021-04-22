package br.com.v2bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.v2bank.enums.RateEnum;
import br.com.v2bank.enums.TypeAccountEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SavingsAccount extends Account{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1908734868639896065L;
	
	@Column(name="RATE_PER_MONTH")
	private Double interestRate;
	
	
	public static SavingsAccount builder(Account account) {
		
		SavingsAccount savingsAccount =  new SavingsAccount();
		savingsAccount.setBalance(account.getBalance());
		savingsAccount.setNumberAgency(account.getNumberAgency());
		savingsAccount.setNumberAccount(account.getNumberAccount());
		savingsAccount.setTypeAccount(TypeAccountEnum.SAVINGS_ACCOUNT);
		savingsAccount.setClient(account.getClient());
		savingsAccount.setInterestRate(RateEnum.RATE_MONTH.tax); //Taxa de Juros deverá ser criada => Constante ou Enum
		
		return savingsAccount;
	}
}
