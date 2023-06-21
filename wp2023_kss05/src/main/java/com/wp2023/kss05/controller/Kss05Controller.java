package com.wp2023.kss05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Kss05Controller {
	
	@GetMapping("/kss05home")
	public void home() {

	}
	
	@GetMapping({"/kss05exam1", "/kss05exam2", "/kss05exam3", "/kss05exam4"})
	public void hello() {
		
	}
	
	@GetMapping({"/kss05exam1_c", "/kss05exam1_r", "/kss05exam1_u", "/kss05exam1_d"})
	public void exam1() {
		
	}
	
	@GetMapping({"/kss05exam2_c", "/kss05exam2_r", "/kss05exam2_u", "/kss05exam2_d", "/kss05exam2_input"})
	public void exam2() {
		
	}

	
}
