package br.com.v2bank.entity;

import javax.persistence.Entity;

import br.com.v2bank.enums.TypeAccountEnum;

@Entity
public class CurrentAccount extends Account{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 354484380539314549L;

	public static CurrentAccount builder(Account account) {
		
		CurrentAccount currentAccount = new CurrentAccount();
		currentAccount.setNumberAgency(account.getNumberAgency());
		currentAccount.setNumberAccount(account.getNumberAccount());
		currentAccount.setTypeAccount(TypeAccountEnum.CURRENT_ACCOUNT);
		currentAccount.setBalance(account.getBalance());
		currentAccount.setClient(account.getClient());
		
		return currentAccount; 
	}

}
