package br.com.v2bank.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.v2bank.dto.AccountConverterDTO;
import br.com.v2bank.dto.AccountDTO;
import br.com.v2bank.entity.Account;
import br.com.v2bank.service.AccountService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountResource {
	
	private final AccountService accountService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		return ResponseEntity.ok(accountService.create(account));
	}
	
	@GetMapping("/buscar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(AccountConverterDTO.converterToAccountDTO(this.accountService.getById(id).get()));
	}
	
	@GetMapping("/buscar-conta/{numberAccount}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<AccountDTO> getAccountByNumber(@PathVariable("numberAccount") String numberAccount) {
		return ResponseEntity.ok(AccountConverterDTO.converterToAccountDTO(this.accountService.getByNumberAccount(numberAccount).get()));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Void> deleteAccountById(@PathVariable("id") Long id) {
		
		try {
			
			this.accountService.removeById(id);
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/remover/{numberAccount}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Void> deleteByNumberAccount (@PathVariable("numberAccount") String numberAccount) {
		
		try {
			this.accountService.removeByNumberAccount(numberAccount);
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PutMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO dto, @RequestParam("numberAccount") String numberAccount) throws Exception {
		return ResponseEntity.ok(AccountConverterDTO.converterToAccountDTO(this.accountService.create(this.accountService.getByNumberAccount(numberAccount).get())));
	
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<AccountDTO>> getAllAccounts() {
		return ResponseEntity.ok(AccountConverterDTO.converterListAccounts(this.accountService.getAll()));
	}

}
