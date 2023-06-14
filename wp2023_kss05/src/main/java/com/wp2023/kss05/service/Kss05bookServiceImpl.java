package com.wp2023.kss05.service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wp2023.kss05.dto.Kss05bookDTO;
import com.wp2023.kss05.dto.Kss05bookcategoryDTO;
import com.wp2023.kss05.dto.PageRequestDTO;
import com.wp2023.kss05.dto.PageResultDTO;
import com.wp2023.kss05.entity.Kss05book;
import com.wp2023.kss05.entity.Kss05bookcategory;
import com.wp2023.kss05.repository.Kss05bookRepository;
import com.wp2023.kss05.repository.Kss05bookcategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class Kss05bookServiceImpl implements Kss05bookService {

	private final Kss05bookRepository bookRepository;
	
	@Override
	public void register(Kss05bookDTO dto) {
		
		Kss05book book = dtoToEntity(dto);
		System.out.print(book);
		bookRepository.save(book);
		
	}
	
	@Override
	public void createDummyData() {
		
        IntStream.rangeClosed(1, 3000).forEach(i -> {
            
			long cno = (long)(Math.random() * 100) + 1;
			
			Kss05bookcategory kss05bookcategory = Kss05bookcategory.builder().cno(cno).build();			
				
			Kss05book kss05book = Kss05book.builder()
					.bname("KSS05서적명..." + (i))
					.bauthor("저자..." + (i))
//	                .bpulicationyear(LocalDateTime.now())
					.bpublisher("출판사..." + (i))
					.category(kss05bookcategory)
					.build();
			
			bookRepository.save(kss05book);
			
        });
		
	}
	
//	@Test
//	public void insertBoard() {
//		
//		IntStream.rangeClosed(1, 100).forEach(i -> {
//			
//			long cno = (long)(Math.random() * 10) + 1;
//			
//			Kss05bookcategory kss05bookcategory = Kss05bookcategory.builder().cno(cno).build();
//			
////			long bno = (long)(Math.random() * 100 ) + 1;
////			
////			Board board = Board.builder().bno(bno).build();
////					
//					
//			Kss05book kss05book = Kss05book.builder()
//					.bname("제목타이름..." + (i%5))
//					.bauthor("내용..." + (i%8))
//	                .bpulicationyear(LocalDateTime.now())
//					.bpublisher("내용..." + (i%8))
//					.category(kss05bookcategory)
//					.build();
//			
//			kss05Repository.save(kss05book);
//			
//			
//		});
//	}
	
	
	
	@Override
	public PageResultDTO<Kss05bookDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
		log.info(pageRequestDTO);
		
		Function<Object[], Kss05bookDTO> fn = ( en -> entityToDTO((Kss05book)en[0], (Kss05bookcategory)en[1] ));
		// fn 은 book 엔터티 가져옴 
		
		Page<Object[]> result = bookRepository.searchPage(
				pageRequestDTO.getType(),
				pageRequestDTO.getKeyword(),
				pageRequestDTO.getPageable(Sort.by("bid").descending()));
		// result 는 검색된 조건 가져옴 
		
		return new PageResultDTO<>(result, fn);
		// PageResult 에서 result 와 fn 조합으로 dtoList와 pageList를 뽑아낸다 
	}
	
	// get은 read와 modify get요청 시 필요함 1개의 id 해당 데이터 조회 
	@Override
	public Kss05bookDTO get(Long bid) {

		Object result = bookRepository.getBookByBid(bid);
		Object[] arr = (Object[])result;
		
		return entityToDTO((Kss05book)arr[0], (Kss05bookcategory)arr[1] );
		
	}


	@Override
	public void modify(Kss05bookDTO dto) {

		Kss05book book = bookRepository.getOne(dto.getBid());
		
//		book.changeTitle(bookDTO.getTitle());
//		book.changeContent(bookDTO.getCdtoontent());
		book.changeBname(dto.getBname());
		book.changeBauthor (dto.getBauthor());
		
		System.out.println("book--------" + book);
		
		bookRepository.save(book);
		
	}

	@Override
	public void remove(Long bid) {
		
		bookRepository.deleteById(bid);
		
	}



}
