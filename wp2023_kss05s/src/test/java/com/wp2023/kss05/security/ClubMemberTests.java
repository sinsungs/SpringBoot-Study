package com.wp2023.kss05.security;

import java.util.HashSet;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.wp2023.kss05.entity.kss05_member;
import com.wp2023.kss05.entity.kss05_member_role_set;
import com.wp2023.kss05.repository.kss05MemberRepository;

@SpringBootTest
public class ClubMemberTests {

	@Autowired
	private kss05MemberRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void insertDummies() {

		IntStream.rangeClosed(1, 100).forEach(i -> {
			
			kss05_member member = kss05_member.builder()
					.email("user" + i + "@king.kong.com")
					.name("사용자" + i)
					.fromSocial(false)
					.roleSet(new HashSet<kss05_member_role_set>())
					.password(passwordEncoder.encode("1111"))
					.address("주소" + i)
					.tel("휴대번호" + i)
					.build();
			
			member.addMemberRole(kss05_member_role_set.GUEST);
			if(i > 80) {
				member.addMemberRole(kss05_member_role_set.MEMBER);
			}
			if(i > 90) {
				member.addMemberRole(kss05_member_role_set.TOPMEM);
			}
			if(i > 95) {
				member.addMemberRole(kss05_member_role_set.MANAGER);
			}
			if(i > 99) {
				member.addMemberRole(kss05_member_role_set.ADMIN);
			}

			repository.save(member);
		
		});
			
	}
	
//	@Test
//	public void testRead() {
//		Optional<ClubMember> result = repository.findByEmail("user95@king.kong.com", false);
//		
//		ClubMember clubMember = result.get();
//		
//		System.out.println(clubMember);
//	}
}















