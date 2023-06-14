package com.wp2023.kss05.dto;

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
public class Kss05bookcategoryDTO {
	
	private Long cno;
	private String cloc;
	private String cname;

}
