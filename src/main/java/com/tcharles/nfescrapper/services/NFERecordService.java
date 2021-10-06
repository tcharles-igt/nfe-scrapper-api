package com.tcharles.nfescrapper.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcharles.nfescrapper.domain.NFErecord;
import com.tcharles.nfescrapper.repository.NFERecordRepository;

@Service
public class NFERecordService {
	
	@Autowired
	private NFERecordRepository repo;
	
	public List<NFErecord> findAll(){
		return repo.findAllByOrderByIdDesc();
	}
	
	public NFErecord find(){
		if(repo.findAllByOrderByIdDesc().isEmpty()) return null;
		return repo.findAllByOrderByIdDesc().get(0);
	}
	
	public List<NFErecord> fullSearch(Date date) {
		Date maxDate = new Date(date.getTime() + 24 * 60 * 60 * 1000);
		return repo.findByDateBetweenOrderByDateDesc(date,maxDate);
	}
}
