package br.com.v2bank.service;

import java.util.List;
import java.util.Optional;

import br.com.v2bank.entity.Account;

public interface AccountService {
	
	Account create(Account account);
	
	Account update(Account account);
	
	Optional<Account> getById(Long id);
	
	Optional<Account> getByNumberAccount(String numberAccount);
	
	List<Account> getAll();
	
	void removeById(Long id) throws Exception;
	
	void removeByNumberAccount(String name) throws Exception;

}
