package br.com.v2bank.service;

import org.springframework.stereotype.Service;

import br.com.v2bank.dto.DepositDTO;
import br.com.v2bank.dto.TransferDTO;
import br.com.v2bank.dto.WithdrawDTO;
import br.com.v2bank.entity.Extract;
import br.com.v2bank.enums.RateEnum;
import br.com.v2bank.enums.TypeAccountEnum;
import br.com.v2bank.enums.TypeOperation;
import lombok.RequiredArgsConstructor;

/**
 * @author Mario Sergio
 *
 */
@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService{
	
	private final AccountService serviceAccount;
	
	private final ExtractServiceImpl serviceExtract;

	@Override
	public DepositDTO deposit(DepositDTO deposit) {
		
		deposit.setAccount(serviceAccount.getById(deposit.getAccount().getId()).get());
		
		if (deposit.getAccount().getBalance() < 0) {
			
			deposit.getAccount().setBalance(deposit.getValue() + deposit.getAccount().getBalance() * RateEnum.NEGATIVE_DEPOSIT_RATE.tax);
			
			Extract extractAccount = Extract.builder(deposit.getAccount(), TypeOperation.DEPOSIT,
					TypeOperation.DEPOSIT.operationSignal + deposit.getValue().toString());
			
			serviceAccount.update(deposit.getAccount());
			
			serviceExtract.create(extractAccount);
			
			return deposit;
		}
		
		deposit.getAccount().setBalance(deposit.getValue() + deposit.getAccount().getBalance());
		
		Extract extractAccount = Extract.builder(deposit.getAccount(), TypeOperation.DEPOSIT,
				TypeOperation.DEPOSIT.operationSignal + deposit.getValue().toString());
		
		serviceAccount.update(deposit.getAccount());
		
		serviceExtract.create(extractAccount);
		
		return deposit;
		
	}

	@Override
	public WithdrawDTO withdraw(WithdrawDTO withdraw) {
		
		withdraw.setAccount(serviceAccount.getById(withdraw.getAccount().getId()).get());
		
		if (withdraw.getAccount().getBalance() > -999) {
			
				withdraw.getAccount().setBalance(withdraw.getAccount().getBalance() - withdraw.getValue());
				
				Extract extractAccount = Extract.builder(withdraw.getAccount(), TypeOperation.WITHDRAW,
						TypeOperation.WITHDRAW.operationSignal + withdraw.getValue().toString());
				
				serviceAccount.update(withdraw.getAccount());
				
				serviceExtract.create(extractAccount);
			
			return withdraw;
		} else {
			
			return null;
		}
	}

	@Override
	public TransferDTO transfer(TransferDTO transfer) {
		
		transfer.setSourceAccount(serviceAccount.getById(transfer.getSourceAccount().getId()).get());
		transfer.setDestinationAccount(serviceAccount.getById(transfer.getDestinationAccount().getId()).get());
		
		if(transfer.getSourceAccount().getNumberAgency() == transfer.getDestinationAccount().getNumberAgency() 
				&& verifyBalanceAccount(transfer)) {
			
			Extract extractAccount = Extract.builder(transfer.getSourceAccount(), transfer.getDestinationAccount(), TypeOperation.TRANSFER,
					TypeOperation.TRANSFER.operationSignal + transfer.getValue().toString());
			
			WithdrawDTO withdraw = new WithdrawDTO();
			withdraw.setAccount(transfer.getSourceAccount());
			withdraw.setValue(transfer.getValue());
			withdraw(withdraw);
			
			DepositDTO deposit = new DepositDTO();
			deposit.setAccount(transfer.getDestinationAccount());
			deposit.setValue(transfer.getValue());
			deposit(deposit);
			
			serviceExtract.create(extractAccount);
			
		} else if(transfer.getSourceAccount().getNumberAgency() != transfer.getDestinationAccount().getNumberAgency() 
				&& verifyBalanceAccount(transfer) 
				&& transfer.getSourceAccount().getTypeAccount() == TypeAccountEnum.CURRENT_ACCOUNT
				&& transfer.getDestinationAccount().getTypeAccount() == TypeAccountEnum.CURRENT_ACCOUNT) {
			
			Extract extractAccount = Extract.builder(transfer.getSourceAccount(), transfer.getDestinationAccount(), TypeOperation.TRANSFER,
					TypeOperation.TRANSFER.operationSignal + transfer.getValue().toString());
			
			Double originalValue = transfer.getValue();
			
			transfer.setValue(transfer.getValue() * RateEnum.CURRENT_ACCOUNT_RATE.tax);
			
			WithdrawDTO withdraw = new WithdrawDTO();
			withdraw.setAccount(transfer.getSourceAccount());
			withdraw.setValue(transfer.getValue());
			withdraw(withdraw);
			
			DepositDTO deposit = new DepositDTO();
			deposit.setAccount(transfer.getDestinationAccount());
			deposit.setValue(originalValue);
			deposit(deposit);
			
			serviceExtract.create(extractAccount);
		
		}
		
		return null;
	}
		
		private boolean verifyBalanceAccount(TransferDTO transfer) {
			
			if (transfer.getSourceAccount().getBalance() >= transfer.getValue()) {
				return true;
				
			} else {
				return false;
			}
			
		}

}
