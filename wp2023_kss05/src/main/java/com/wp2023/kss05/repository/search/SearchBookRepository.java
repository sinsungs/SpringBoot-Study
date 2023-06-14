package com.wp2023.kss05.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wp2023.kss05.entity.Kss05bookcategory;

public interface SearchBookRepository {
//	Kss05bookcategory search1();
	
	Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
