package com.wp2023.kss05.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Zep {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	private String cvzepid;
	private String cvtime;
	private Long cvsuccessornot;
	
}

//cid: 1,
//cvzepid: sender.name,
//cvtime: currentTime,
//cvsuccessornot: 1