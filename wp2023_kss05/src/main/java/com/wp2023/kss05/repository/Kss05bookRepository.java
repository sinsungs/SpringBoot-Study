package com.wp2023.kss05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wp2023.kss05.entity.Kss05book;
import com.wp2023.kss05.repository.search.SearchBookRepository;

public interface Kss05bookRepository extends JpaRepository<Kss05book, Long>, SearchBookRepository{

	
	@Query("SELECT b, w " +
			" FROM Kss05book b LEFT JOIN b.category w " +
			" WHERE b.bid = :bid ")
	Object getBookByBid(@Param("bid") Long bid);
	
}


