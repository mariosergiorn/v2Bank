package br.com.v2bank.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.v2bank.entity.Extract;

@Component
public class ExtractConverterDTO {

	public static ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static List<ExtractDTO> conveterListExtratc(List<Extract> extratc){
		return extratc
				.stream()
				.map(c -> modelMapper().map(c, ExtractDTO.class))
				.collect(Collectors.toList());
	}
	
}
