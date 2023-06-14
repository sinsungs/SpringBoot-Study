package com.wp2023.kss05.repository;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wp2023.kss05.entity.Kss05bookcategory;


@SpringBootTest
public class Kss05bookcategoryRepositoryTest {
	
	@Autowired
	private Kss05bookcategoryRepository kss05bookrepository;
	

	
	@Test
	public void insertBoard() {
		
		IntStream.rangeClosed(1, 256).forEach(i -> {
			
//	        long cno = (long)(Math.random() * 100) + 1;
	        long cname = ThreadLocalRandom.current().nextInt(1, 11); // Generates random numbers from 1 to 10
	        long cloc = ThreadLocalRandom.current().nextInt(1, 4); // Generates random numbers 1, 2, or 3
			
			Kss05bookcategory kss05bookcategory = Kss05bookcategory.builder()
					.cname("카테고리KSS05..." + (i))
					.cloc("소장장소..." + (cloc) + "층" + (cname) + "구역")
					.build();
			
			kss05bookrepository.save(kss05bookcategory);
			
			
		});
	}
	
	
	
	
//	@Test
//	public void insertBoard() {
//		
//		IntStream.rangeClosed(1, 100).forEach(i -> {
//			Member member = Member.builder().email("user" + i + "@king.kong.com").build();
//					
//			Board board = Board.builder()
//					.title("제목타이름..." + (i%5))
//					.content("내용..." + (i%8))
//					.writer(member)
//					.build();
//			
//			boardRepository.save(board);
//		});
//	}
	
	
	
}
