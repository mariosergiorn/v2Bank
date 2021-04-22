/**
 * 
 */
package br.com.v2bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.v2bank.entity.Extract;
import br.com.v2bank.repository.ExtractRepository;
import lombok.RequiredArgsConstructor;

/**
 * @author Mario Sergio
 *
 */

@Service
@RequiredArgsConstructor
public class ExtractServiceImpl implements ExtractService {
	
	private final ExtractRepository repository;
	
	@Override
	public List<Extract> getAll() {

		return this.repository.findAll();
	}

	@Override
	public Extract create(Extract extract) {
		
		return this.repository.save(extract);
	}

}
