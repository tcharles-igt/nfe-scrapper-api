package com.tcharles.nfescrapper.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tcharles.nfescrapper.domain.NFErecord;

public class NFERecordDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date date;
	
	private List<StateDTO> states = new ArrayList<>();
	
	public NFERecordDTO() {
		
	}
	
	public NFERecordDTO(NFErecord obj) {
		id = obj.getId();
		date = obj.getDate();
		states = obj.getStates();
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

	public List<StateDTO> getStates() {
		return states;
	}

	public void setStstes(List<StateDTO> ststes) {
		this.states = ststes;
	}
	
	
	
}
