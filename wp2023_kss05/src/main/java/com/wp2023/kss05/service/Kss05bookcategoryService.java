package com.wp2023.kss05.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wp2023.kss05.dto.Kss05bookcategoryDTO;
import com.wp2023.kss05.entity.Kss05bookcategory;

public interface Kss05bookcategoryService {
	
	void register(Kss05bookcategoryDTO dto);
	
	void createDummyData();
	
	Page<Kss05bookcategory> getList(Pageable pageable);

	Kss05bookcategoryDTO get(Long cno);
	
	void modify(Kss05bookcategoryDTO dto);
	
	void remove(Long cno);
	
	default Kss05bookcategory dtoToEntity(Kss05bookcategoryDTO dto) {
		
		Kss05bookcategory book = Kss05bookcategory.builder()
				.cno(dto.getCno())
				.cname(dto.getCname())
				.cloc(dto.getCloc())
				.build();
		
		return book;
	}
//	
	default Kss05bookcategoryDTO entityToDTO(Kss05bookcategory book) {
		
		Kss05bookcategoryDTO bookDTO = Kss05bookcategoryDTO.builder()
				.cno(book.getCno())
				.cname(book.getCname())
				.cloc(book.getCloc())

				.build();
		
		return bookDTO;
		
	}
	
	
}
