package com.wp2023.kss05.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Kss05bookcategory{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cno;
	private String cname;
	private String cloc;	

	
	public void changeCname(String cname) {
		this.cname = cname;
	}
	
	public void changeCloc(String cloc) {
		this.cloc = cloc;
	}
	
	
}

