package com.wp2023.kss05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/")
public class kss05FirstController {
	
	@GetMapping({"/kss05login", "/login", "/kss05exam5", "/kss05home"})
	public void login() {
		
	}
	
	@GetMapping("/kss05logout")
	public void logout() {
		
	}
	
	@GetMapping("/guest/kss05guest")
	public void guest() {
//		return "/guest/kss05guest";
	}
	
	@GetMapping("/member/kss05member")
	public void member() {
//		return "/member/kss05member";
	}
	
	@GetMapping("/topmem/kss05topmem")
	public void topmem() {
//		return "/topmem/kss05topmem";
	}
	
	@GetMapping("/manager/kss05manager")
	public void manager() {
//		return "/manager/kss05manager";
	}
	
	@GetMapping("/admin/kss05admin")
	public void admin() {
//		return "/admin/kss05admin";
	}
	


	
}