package com.wp2023.kss05.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@ToString
public class kss05AuthMemberDTO extends User {
	
	private String email;
	private String name;
	private boolean fromSocial;
	
	public kss05AuthMemberDTO(
			String username, String password, boolean fromSocial,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.email = username;
		this.fromSocial = fromSocial;
	}
}
