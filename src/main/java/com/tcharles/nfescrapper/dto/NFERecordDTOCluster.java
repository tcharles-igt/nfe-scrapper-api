package com.tcharles.nfescrapper.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tcharles.nfescrapper.domain.NFErecord;

public class NFERecordDTOCluster {
	private String id;
	private Date date;
	
	private List<StateDTO> states = new ArrayList<>();
	
	public NFERecordDTOCluster() {
		
	}
	
	public NFERecordDTOCluster(List<NFErecord> objs) {
		id = objs.get(0).getId();
		date = objs.get(0).getDate();
		states = statesCluster(objs);
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

	public void setStates(List<StateDTO> states) {
		this.states = states;
	}
	
	private List<StateDTO> statesCluster(List<NFErecord> objs){
		List<StateDTO> s = new ArrayList<>();
		for(NFErecord obj: objs) {
			if(s.isEmpty()) {
				s = obj.getStates();
			}
			else {
				List<StateDTO> satates = obj.getStates();
				s = statesSum(satates,s);
			}
		}
		
		return s;
	}
	
	private List<StateDTO> statesSum(List<StateDTO> s1, List<StateDTO> s2){
		for(StateDTO state: s1) {
			int i = 0; 
			for (StateDTO x:s2) {
				if(x.getName().equals(state.getName())) {
					s2.get(i).setOutages(state.getOutages()+x.getOutages());
				}
				i++;
			}
		}
		
		return s2;
	}
}
