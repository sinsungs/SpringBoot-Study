package com.wp2023.kss05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wp2023.kss05.dto.Kss05bookDTO;
import com.wp2023.kss05.dto.PageRequestDTO;
import com.wp2023.kss05.service.Kss05bookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/book/")
@Log4j2
@RequiredArgsConstructor
public class Kss05bookController {

	private final Kss05bookService bookService;
	
	@GetMapping("/register")
	public void register() {
		log.info("register get..........");
	}
	
	@PostMapping("/register")
	public void registerPost(Kss05bookDTO dto, RedirectAttributes redirectAttributes) {
		log.info("dto...." + dto);
		
		bookService.register(dto);
		
	}
	
    @GetMapping("/dummy")
    public String createDummyData() {
    	
    	bookService.createDummyData();
    	
		return "redirect:/book/list";
        
    }
	
	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model) {
		log.info("list..............." + pageRequestDTO);
		
		model.addAttribute("result", bookService.getList(pageRequestDTO));
	}
	

	@GetMapping({"/read", "/modify"})
	public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long bid, Model model) {
		log.info("bid: " + bid);
		
		Kss05bookDTO bookDTO = bookService.get(bid);
		
		log.info(bookDTO);
		
		model.addAttribute("dto", bookDTO);
	}
	
	
	@PostMapping("/modify")
	public String modify(Kss05bookDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
			RedirectAttributes redirectAttributes) {
		log.info("post modify...............");
		log.info("dto: " + dto);
		
		bookService.modify(dto);
		
		redirectAttributes.addAttribute("page", requestDTO.getPage());
		redirectAttributes.addAttribute("type", requestDTO.getType());
		redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());
		
		redirectAttributes.addAttribute("bid", dto.getBid());
		
		return "redirect:/book/read";
	}
    

	@PostMapping("/remove")
	public String remove(long bid, RedirectAttributes redirectAttributes) {
		log.info("bid: " + bid);
		bookService.remove(bid);
		redirectAttributes.addFlashAttribute("msg", bid);
		return "redirect:/book/list";
	}
	
    
    
}
