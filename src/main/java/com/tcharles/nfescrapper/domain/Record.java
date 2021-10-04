package com.tcharles.nfescrapper.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tcharles.nfescrapper.dto.StateDTO;

@Document
public class Record implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date date;
	
	private List<StateDTO> ststes = new ArrayList<>();
	
	public Record() {
		
	}

	public Record(String id, Date date, List<StateDTO> ststes) {
		super();
		this.id = id;
		this.date = date;
		this.ststes = ststes;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		return Objects.equals(id, other.id);
	}
}
