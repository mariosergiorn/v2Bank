package br.com.v2bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.v2bank.entity.Account;
import br.com.v2bank.entity.Client;
import br.com.v2bank.entity.CurrentAccount;
import br.com.v2bank.entity.SavingsAccount;
import br.com.v2bank.enums.TypeAccountEnum;
import br.com.v2bank.exceptions.AccountNotFoundException;
import br.com.v2bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
	
	private final AccountRepository repository;
	private final ClientService clientService;
	
	@Override
	public Account create(Account accountRequest) {
		
        Long idClient = accountRequest.getClient().getId();
        Client client = null;
        Account account = null; 

        if(accountRequest.getTypeAccount().compareTo(TypeAccountEnum.CURRENT_ACCOUNT) == 0){

            client = clientService.getById(idClient).get();

            accountRequest.setClient(client);
            account = CurrentAccount.builder(accountRequest);
        }
        else if(accountRequest.getTypeAccount().compareTo(TypeAccountEnum.SAVINGS_ACCOUNT) == 0) {

            client = clientService.getById(idClient).get();

            accountRequest.setClient(client);
            account = SavingsAccount.builder(accountRequest);
        }
        else {
            throw new RuntimeException();
        }

        return this.repository.save(account);
        
    }
		
	
	@Override
	public List<Account> getAll(){
		return this.repository.findAll();
	}
	
	@Override
	public Optional<Account> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Optional<Account> getByNumberAccount(String numberAccount) {
		return this.repository.findByNumberAccount(numberAccount);
	}

	@Override
	public void removeByNumberAccount (String numberAccount) throws Exception {
		if (this.repository.findByNumberAccount(numberAccount).get() != null) {
			this.repository.deleteByNumberAccount(numberAccount);
		} else {
			throw new AccountNotFoundException(HttpStatus.NOT_FOUND, "Account not found");
		}
	}

	@Override
	public void removeById(Long id) throws Exception {
		if (this.repository.findById(id).get() != null) {
			this.repository.deleteById(id);
		} else {
			throw new AccountNotFoundException(HttpStatus.NOT_FOUND, "Account not found");
		}
		
	}


	@Override
	public Account update(Account account) {
		return this.repository.save(account);
	}
}
