package com.wp2023.kss05.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wp2023.kss05.dto.kss05AuthMemberDTO;
import com.wp2023.kss05.entity.kss05_member;
import com.wp2023.kss05.repository.kss05MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class kss05UserDetailsService implements UserDetailsService{

	private final kss05MemberRepository clubMemberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("ClubUserDetailsService loadUserByUsername " + username);
		
		Optional<kss05_member> result = clubMemberRepository.findByEmail(username, false);
		
		if(result.isEmpty()) {
			throw new UsernameNotFoundException("check Email or Social");
		}
		
		kss05_member clubMember = result.get();
		
		log.info("-----------------------------");
		log.info(clubMember);
		
		kss05AuthMemberDTO clubAuthMember = new kss05AuthMemberDTO(
				clubMember.getEmail(),
				clubMember.getPassword(),
				clubMember.isFromSocial(),
				clubMember.getRoleSet().stream()
				.map(role -> new SimpleGrantedAuthority(
						"ROLE_" + role.name())).collect(Collectors.toSet())
				);
		clubAuthMember.setName(clubMember.getName());
		clubAuthMember.setFromSocial(clubMember.isFromSocial());
		
		return clubAuthMember;
	}

	
}
