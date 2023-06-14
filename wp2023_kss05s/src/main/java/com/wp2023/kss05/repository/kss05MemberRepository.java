package com.wp2023.kss05.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wp2023.kss05.entity.kss05_member;

public interface kss05MemberRepository extends JpaRepository<kss05_member, String>{
	
	@EntityGraph(attributePaths = {"roleSet"}, type=EntityGraph.EntityGraphType.LOAD)
	@Query("select m from kss05_member m where m.fromSocial = :social and m.email = :email")
	Optional<kss05_member> findByEmail(@Param("email") String email, @Param("social") boolean social);
}
