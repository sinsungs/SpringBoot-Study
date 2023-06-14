package com.wp2023.kss05.repository;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wp2023.kss05.entity.Kss05book;
import com.wp2023.kss05.entity.Kss05bookcategory;

@SpringBootTest
public class Kss05RepositoryTest {

	@Autowired
	private Kss05Repository kss05Repository;
	
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
	
}
