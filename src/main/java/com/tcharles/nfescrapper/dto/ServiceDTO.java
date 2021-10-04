package com.tcharles.nfescrapper.dto;

import java.io.Serializable;

public class ServiceDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String status;
	
	public ServiceDTO() {
		
	}

	public ServiceDTO(String name, String status) {
		super();
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
