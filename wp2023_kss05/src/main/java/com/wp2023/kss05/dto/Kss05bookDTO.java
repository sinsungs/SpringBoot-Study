package com.wp2023.kss05.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Kss05bookDTO {
	
	private Long bid;
	private String bname;
	private String bauthor;
	private LocalDateTime bpulicationyear;
	private String bpublisher;
	private Long bcno;
	
}
