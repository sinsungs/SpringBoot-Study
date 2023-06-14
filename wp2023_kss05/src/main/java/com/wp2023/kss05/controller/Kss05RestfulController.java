package com.wp2023.kss05.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wp2023.kss05.dto.Kss05bookcategoryDTO;
import com.wp2023.kss05.entity.Kss05bookcategory;
import com.wp2023.kss05.service.Kss05bookcategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@Log4j2
@RequiredArgsConstructor
public class Kss05RestfulController {

    private final Kss05bookcategoryService categoryService;

    @GetMapping("/register")
    public ResponseEntity<String> register() {
        log.info("register get..........");
        return ResponseEntity.ok("Register Get Request Successful");
    }

    @PutMapping("/register")
    public ResponseEntity<String> registerPost(@RequestBody Kss05bookcategoryDTO dto) {
        log.info("dto...." + dto);
        categoryService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Resource Created Successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Kss05bookcategory>> list(@PageableDefault(page = 0, size = 10, sort = "cno", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Kss05bookcategory> result = categoryService.getList(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{cno}")
    public ResponseEntity<Kss05bookcategoryDTO> read(@PathVariable Long cno) {
        log.info("cno: " + cno);
        Kss05bookcategoryDTO categoryDTO = categoryService.get(cno);
        return ResponseEntity.ok(categoryDTO);
    }

    @PatchMapping("/{cno}")
    public ResponseEntity<String> modify(@PathVariable Long cno, @RequestBody Kss05bookcategoryDTO dto) {
        log.info("post modify...............");
        log.info("dto: " + dto);
        categoryService.modify(dto);
        return ResponseEntity.ok("Resource Modified Successfully");
    }

    @DeleteMapping("/{cno}")
    public ResponseEntity<String> remove(@PathVariable long cno) {
        log.info("cno: " + cno);
        categoryService.remove(cno);
        return ResponseEntity.ok("Resource Delete Successfully");
    }
    
}



