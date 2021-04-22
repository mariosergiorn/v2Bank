package br.com.v2bank.service;

import br.com.v2bank.dto.DepositDTO;
import br.com.v2bank.dto.TransferDTO;
import br.com.v2bank.dto.WithdrawDTO;

/**
 * @author Mario Sergio
 *
 */
public interface OperationService {
	
		DepositDTO deposit(DepositDTO deposit);
		
		WithdrawDTO withdraw(WithdrawDTO withdraw);
		
		TransferDTO transfer(TransferDTO transfer);

	}
