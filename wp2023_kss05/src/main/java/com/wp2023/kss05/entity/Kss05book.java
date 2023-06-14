package com.wp2023.kss05.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(value = {AuditingEntityListener.class})
public class Kss05book{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bid;
	private String bname;
	private String bauthor;	
	private String bpublisher;	
	
	@CreatedDate
	private LocalDateTime bpulicationyear;	

	@ManyToOne
	private Kss05bookcategory category;  // Member와 연관관계 지정
	
	public void changeBname(String bname) {
		this.bname = bname;
	}
	
	public void changeBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	
}
