package com.tcharles.nfescrapper.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tcharles.nfescrapper.domain.Record;

public class RecordDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date date;
	
	private List<StateDTO> ststes = new ArrayList<>();
	
	public RecordDTO() {
		
	}
	
	public RecordDTO(Record obj) {
		id = obj.getId();
		date = obj.getDate();
		ststes = obj.getStstes();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<StateDTO> getStstes() {
		return ststes;
	}

	public void setStstes(List<StateDTO> ststes) {
		this.ststes = ststes;
	}
	
	
	
}
