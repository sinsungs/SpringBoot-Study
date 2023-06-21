package com.wp2023.kss05.service;

import org.springframework.stereotype.Service;

import com.wp2023.kss05.dto.ZepRequestDto;
import com.wp2023.kss05.entity.Zep;
import com.wp2023.kss05.repository.ZepRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ZepServiceImpl implements ZepService {
	
	private final ZepRepository zepRepository;

	@Override
	public void register(ZepRequestDto dto) {

	
	    Zep zep = new Zep();
	    zep.setCvzepid(dto.getCvzepid());
	    zep.setCvtime(dto.getCvtime());
	    zep.setCvsuccessornot(dto.getCvsuccessornot());
	    System.out.print(zep);

	    zepRepository.save(zep);
		
		
	}

//	@Override
//	public void list() {
//		// TODO Auto-generated method stub
//		
//	}



}
