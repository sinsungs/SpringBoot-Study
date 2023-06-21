package com.wp2023.kss05.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wp2023.kss05.dto.ZepRequestDto;
import com.wp2023.kss05.service.ZepService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ZepController {
	
    private final ZepService zepService;
    
	@PostMapping("/register")
	public ResponseEntity<String> Register(@RequestBody ZepRequestDto dto) {
		
		System.out.print(dto);
		
		zepService.register(dto);
		
        return ResponseEntity.ok("succuess");
		
	}
	
//	@GetMapping("/list")
//	public void List(Model model) {
//		
//	    List<YoutuberDTO> youtubers = zepService.list();
//	    model.addAttribute("youtubers", youtubers);
//	    
//	}

}
