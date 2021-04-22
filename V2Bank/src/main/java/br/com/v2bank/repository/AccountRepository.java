package br.com.v2bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.v2bank.entity.Account;
import br.com.v2bank.entity.Client;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Optional<Account> findByNumberAccount(String numberAccount);
	
	void deleteByNumberAccount(String numberAccount);

}
