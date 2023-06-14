package com.wp2023.kss05.service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wp2023.kss05.dto.Kss05bookcategoryDTO;
import com.wp2023.kss05.entity.Kss05bookcategory;
import com.wp2023.kss05.repository.Kss05bookcategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class Kss05bookcategoryServiceImpl implements Kss05bookcategoryService {

	private final Kss05bookcategoryRepository categoryRepository;
	

	@Override
	public void register(Kss05bookcategoryDTO dto) {

		Kss05bookcategory book = dtoToEntity(dto);
		categoryRepository.save(book);
		
	}
	
	@Override
	public void createDummyData() {
		
        IntStream.rangeClosed(1, 256).forEach(i -> {
            long cname = ThreadLocalRandom.current().nextInt(1, 11); 
            long cloc = ThreadLocalRandom.current().nextInt(1, 4); 

			Kss05bookcategory kss05bookcategory = Kss05bookcategory.builder()
					.cname("카테고리KSS05..." + (i))
					.cloc("소장장소..." + (cloc) + "층" + (cname) + "구역")
					.build();
			
            categoryRepository.save(kss05bookcategory);
        });
		
	}
	
//	@Override
//	public PageResultDTO<Kss05bookcategoryDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
//
//		Function<Object[], Kss05bookcategoryDTO> fn = ( en -> entityToDTO((Kss05bookcategory)en[0]));
//		
//		Page<Object[]> result = categoryRepository.searchPage(
//				pageRequestDTO.getType(),
//				pageRequestDTO.getKeyword(),
//				pageRequestDTO.getPageable(Sort.by("cno").descending()));
//		
//		return new PageResultDTO<>(result, fn);
//	}
	
	
	@Override
	public Page<Kss05bookcategory> getList(Pageable pageable) {

		return categoryRepository.findAll(pageable);
	}

	
//	// get은 read와 modify get요청 시 필요함 1개의 id 해당 데이터 조회 
//	@Override
//	public Kss05bookcategoryDTO get(Long cno) {
//
//		Object result = categoryRepository.findById(cno);
//		Object[] arr = (Object[])result;
//		
//		return entityToDTO((Kss05bookcategory)arr[0] );
//		
//	}

	@Override
	public Kss05bookcategoryDTO get(Long cno) {
	    Optional<Kss05bookcategory> optionalCategory = categoryRepository.findById(cno);
	    if (optionalCategory.isPresent()) {
	        Kss05bookcategory category = optionalCategory.get();
	        return entityToDTO(category);
	    }
	    // Handle the case when the entity is not found
	    return null;
	}

	@Override
	public void modify(Kss05bookcategoryDTO dto) {

		Kss05bookcategory category = categoryRepository.getOne(dto.getCno());
//		
		category.changeCname(dto.getCname());
		category.changeCloc (dto.getCloc());
		
		System.out.println("category--------" + category);
		
		categoryRepository.save(category);
		
	}

	@Override
	public void remove(Long cno) {
		
		categoryRepository.deleteById(cno);
		
	}





}
