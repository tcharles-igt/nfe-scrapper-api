package com.tcharles.nfescrapper.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StateDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String name;
	private int outages;
	
	private List<ServiceDTO> services = new ArrayList<>();
	
	public StateDTO() {
		
	}

	public StateDTO(String name, int outages, List<ServiceDTO> services) {
		super();
		this.name = name;
		this.outages = outages;
		this.services = services;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getOutages() {
		return outages;
	}

	public void setOutages(int outages) {
		this.outages = outages;
	}

	public List<ServiceDTO> getServices() {
		return services;
	}

	public void setServices(List<ServiceDTO> services) {
		this.services = services;
	}
	
}
