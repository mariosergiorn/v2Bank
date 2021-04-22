/**
 * 
 */
package br.com.v2bank.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.v2bank.dto.ExtractConverterDTO;
import br.com.v2bank.dto.ExtractDTO;
import br.com.v2bank.service.ExtractService;
import lombok.RequiredArgsConstructor;

/**
 * @author Mario Sergio
 *
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/extract")
public class ExtractResource {
	
	private final ExtractService extractService;
	
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<ExtractDTO>> getAll() {
		return ResponseEntity.ok(ExtractConverterDTO.conveterListExtratc(this.extractService.getAll()));
	}

}
