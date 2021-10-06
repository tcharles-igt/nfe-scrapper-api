package com.tcharles.nfescrapper.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tcharles.nfescrapper.domain.NFErecord;

@Repository
public interface NFERecordRepository extends MongoRepository<NFErecord, String> {
	
	public List<NFErecord> findAllByOrderByIdDesc();
	
	public List<NFErecord> findByDateBetweenOrderByDateDesc(Date minDate,Date maxDate);
	
}
