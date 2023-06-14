package com.wp2023.kss05.service;

import java.time.LocalDateTime;

import com.wp2023.kss05.dto.Kss05bookDTO;
import com.wp2023.kss05.dto.Kss05bookcategoryDTO;
import com.wp2023.kss05.dto.PageRequestDTO;
import com.wp2023.kss05.dto.PageResultDTO;
import com.wp2023.kss05.entity.Kss05book;
import com.wp2023.kss05.entity.Kss05bookcategory;

public interface Kss05bookService {
	
	void register(Kss05bookDTO dto);
	
	void createDummyData();
	
	PageResultDTO<Kss05bookDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
	
	Kss05bookDTO get(Long bid);
	
	void modify(Kss05bookDTO dto);
	
	void remove(Long bid);
	
	default Kss05book dtoToEntity(Kss05bookDTO dto) {
		Kss05bookcategory category = Kss05bookcategory.builder()
				.cno(dto.getBcno()).build();
		
		Kss05book book = Kss05book.builder()
				.bid(dto.getBid())
				.bname(dto.getBname())
				.bauthor(dto.getBauthor())
				.bpublisher(dto.getBpublisher())
//                .bpulicationyear(LocalDateTime.now())
				.category(category)
				.build();
		
		return book;
	}
//	
	default Kss05bookDTO entityToDTO(Kss05book book, Kss05bookcategory category) {
		
		Kss05bookDTO bookDTO = Kss05bookDTO.builder()
				.bid(book.getBid())
				.bname(book.getBname())
				.bauthor(book.getBauthor())
				.bpublisher(book.getBpublisher())
                .bpulicationyear(book.getBpulicationyear())
				.bcno(category.getCno())
				

				.build();
		
		return bookDTO;
		
	}

}
