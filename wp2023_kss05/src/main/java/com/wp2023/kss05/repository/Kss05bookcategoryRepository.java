package com.wp2023.kss05.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wp2023.kss05.entity.Kss05bookcategory;
import com.wp2023.kss05.repository.search.SearchBookRepository;

public interface Kss05bookcategoryRepository extends JpaRepository<Kss05bookcategory, Long>, SearchBookRepository{
	
	
}
