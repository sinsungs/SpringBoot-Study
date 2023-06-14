package com.wp2023.kss05.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class kss05_member extends BaseEntity {

	@Id
	private String email;
	private String password;
	private String name;
	private String address;
	private String tel;
	private boolean fromSocial;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@Builder.Default
	private Set<kss05_member_role_set> roleSet = new HashSet<>();
	
	public void addMemberRole(kss05_member_role_set clubMemberRole) {
		roleSet.add(clubMemberRole);
	}
	
}
