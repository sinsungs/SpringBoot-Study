package com.wp2023.kss05.repository.search;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.wp2023.kss05.entity.Kss05book;
import com.wp2023.kss05.entity.Kss05bookcategory;
import com.wp2023.kss05.entity.QKss05book;
import com.wp2023.kss05.entity.QKss05bookcategory;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SearchBookRepositoryImpl extends QuerydslRepositorySupport implements SearchBookRepository {
	
	public SearchBookRepositoryImpl() {
		super(Kss05book.class);
	}
	
	@Override
	public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
		
		log.info("searchPage...............");

	    // QBook 클래스 생성

		QKss05bookcategory kss05bookcategory = QKss05bookcategory.kss05bookcategory;
		QKss05book kss05book = QKss05book.kss05book;
		
		// JPQLQuery 객체 생성

		JPQLQuery<Kss05book> jpqlQuery = from(kss05book);
		jpqlQuery.leftJoin(kss05bookcategory).on(kss05book.category.eq(kss05bookcategory));
		
		// Tuple 객체 생성 및 선택할 필드 선택
		JPQLQuery<Tuple> tuple = jpqlQuery.select(kss05book, kss05bookcategory);
		
		// 검색 조건을 위한 BooleanBuilder 생성
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		BooleanExpression expression = kss05book.bid.gt(0L);
		
		booleanBuilder.and(expression);
		
		if(type != null) {
			String[] typeArr = type.split("");
			
			BooleanBuilder conditionBuilder = new BooleanBuilder();
			
			for(String t: typeArr) {
				switch(t) {
				
				case "t" : conditionBuilder.or(kss05bookcategory.cname.contains(keyword)); break;				
				case "w" : conditionBuilder.or(kss05book.bname.contains(keyword)); break;				
				}
			}
			booleanBuilder.and(conditionBuilder);
		}
		
		// 검색 조건 설정
		tuple.where(booleanBuilder);
		
		// 정렬 설정
		Sort sort = pageable.getSort();
		
		sort.stream().forEach(order -> {
			Order direction = order.isAscending()? Order.ASC: Order.DESC;
			String prop = order.getProperty();
			PathBuilder orderByExpression = new PathBuilder(Kss05book.class, "kss05book");
			tuple.orderBy(new OrderSpecifier(direction, orderByExpression.get(prop)));
		});
		
		
		// 그룹화
		tuple.groupBy(kss05book);
		
		// 페이징 설정
		tuple.offset(pageable.getOffset());
		tuple.limit(pageable.getPageSize());
		
		// 결과 조회
		List<Tuple> result = tuple.fetch();
		log.info(result);
		
		// 전체 결과 수 조회
		long count = tuple.fetchCount();
		log.info("COUNT: " + count);
		
		// 페이지 객체 생성하여 결과 반환
		return new PageImpl<Object[]>(
				result.stream().map( t -> t.toArray()).collect(Collectors.toList()), pageable, count);
	}



}
