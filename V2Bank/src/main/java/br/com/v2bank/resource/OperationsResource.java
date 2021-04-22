/**
 * 
 */
package br.com.v2bank.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.v2bank.dto.DepositDTO;
import br.com.v2bank.dto.TransferDTO;
import br.com.v2bank.dto.WithdrawDTO;
import br.com.v2bank.service.OperationService;
import lombok.RequiredArgsConstructor;

/**
 * @author Mario Sergio
 *
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/operations")
public class OperationsResource {
	
	private final OperationService operationService;
	
	@PostMapping("/deposit")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<DepositDTO> deposit(@RequestBody DepositDTO depositDTO) {
		return ResponseEntity.ok(this.operationService.deposit(depositDTO));
	}
	
	@PostMapping("/withdraw")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<WithdrawDTO> withdraw(@RequestBody WithdrawDTO withdrawDTO) {
		return ResponseEntity.ok(operationService.withdraw(withdrawDTO));
	}
	
	@PostMapping("/transfer")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<TransferDTO> transfer(@RequestBody TransferDTO transferDTO) {
		return ResponseEntity.ok(this.operationService.transfer(transferDTO));
	}

}
