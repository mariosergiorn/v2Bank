/**
 * 
 */
package br.com.v2bank.service;

import java.util.List;

import br.com.v2bank.entity.Extract;

/**
 * @author Mario Sergio
 *
 */
public interface ExtractService {
	
	List<Extract> getAll();
	
	Extract create(Extract extratc);

}
