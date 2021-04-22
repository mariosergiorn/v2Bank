package br.com.v2bank.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import br.com.v2bank.entity.Account;

public class AccountConverterDTO {
	
	@Bean
	public static ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static Account converterToAccount(AccountDTO accountDTO) {
		return modelMapper().map(accountDTO, Account.class);
	}
	
	public static AccountDTO converterToAccountDTO(Account account) {
		return modelMapper().map(account, AccountDTO.class);
	}
	
	public static List<AccountDTO> converterListAccounts(List<Account> account) {
		return account
				.stream()
				.map(a -> modelMapper().map(a, AccountDTO.class))
				.collect(Collectors.toList());
		
	}

}
