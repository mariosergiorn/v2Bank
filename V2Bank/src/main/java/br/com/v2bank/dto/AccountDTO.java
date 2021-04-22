package br.com.v2bank.dto;

import br.com.v2bank.entity.Client;
import br.com.v2bank.enums.TypeAccountEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDTO {
	
		private Client client;
		
		private TypeAccountEnum typeAccount;
		
		private int numberAccount;
		
		private int numberAgency;
		
		private Double balance;
		
}
