package br.com.v2bank.enums;

import lombok.AllArgsConstructor;

/**
 * @author Mario Sergio
 *
 */

@AllArgsConstructor
public enum TypeOperation {
	
	DEPOSIT("+"),
	WITHDRAW("-"),
	TRANSFER("");
	
	public final String operationSignal;

}
