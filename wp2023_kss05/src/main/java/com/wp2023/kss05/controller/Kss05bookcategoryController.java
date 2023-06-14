package com.wp2023.kss05.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wp2023.kss05.dto.Kss05bookcategoryDTO;
import com.wp2023.kss05.dto.PageRequestDTO;
import com.wp2023.kss05.entity.Kss05bookcategory;
import com.wp2023.kss05.service.Kss05bookcategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/category")
@Log4j2
@RequiredArgsConstructor
public class Kss05bookcategoryController {
	
	private final Kss05bookcategoryService categoryService;
	
	
	@GetMapping("/register")
	public void register() {
		log.info("register get..........");
	}
	
	@PostMapping("/register")
	public void registerPost(Kss05bookcategoryDTO dto, RedirectAttributes redirectAttributes) {
		log.info("dto...." + dto);
		
		categoryService.register(dto);
		
	}
	
    @GetMapping("/dummy")
    public String createDummyData() {
    	
    	categoryService.createDummyData();
    	
		return "redirect:/category/list";
        
    }
	
	
	@GetMapping("/list")
	public void list(Model model, @PageableDefault(page = 0, size = 10, sort = "cno", direction = Sort.Direction.DESC) Pageable pageable) {
	    Page<Kss05bookcategory> result = categoryService.getList(pageable);
	    
	    int nowPage = result.getPageable().getPageNumber() + 1;
	    int totalBlocks = (int) Math.ceil((double) result.getTotalPages() / 10);
	    int currentBlock = (int) Math.ceil((double) nowPage / 10);
	    int startPage = (currentBlock - 1) * 10 + 1;
	    int endPage = Math.min(startPage + 9, totalBlocks * 10);
	    
	    // Adjust endPage if it exceeds the total number of pages
	    endPage = Math.min(endPage, result.getTotalPages());
	    
	    model.addAttribute("result", result);
	    model.addAttribute("nowPage", nowPage);
	    model.addAttribute("startPage", startPage);
	    model.addAttribute("endPage", endPage);
	}


	@GetMapping({"/read", "/modify"})
	public void read(Long cno, Model model) {
		log.info("cno: " + cno);
		
		Kss05bookcategoryDTO categoryDTO = categoryService.get(cno);
		
		log.info(categoryDTO);
		
		model.addAttribute("dto", categoryDTO);
	}
	
	
	@PostMapping("/modify")
	public String modify(Kss05bookcategoryDTO dto, RedirectAttributes redirectAttributes) {
		log.info("post modify...............");
		log.info("dto: " + dto);
		
		categoryService.modify(dto);
		
		redirectAttributes.addAttribute("cno", dto.getCno());
		
		return "redirect:/category/read";
	}
    
	
	@PostMapping("/remove")
	public String remove(long cno, RedirectAttributes redirectAttributes) {
		log.info("cno: " + cno);
		
		categoryService.remove(cno);
		
		redirectAttributes.addFlashAttribute("msg", cno);
		return "redirect:/category/list";
	}

}
