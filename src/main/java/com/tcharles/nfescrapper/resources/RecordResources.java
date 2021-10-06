package com.tcharles.nfescrapper.resources;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcharles.nfescrapper.domain.NFErecord;
import com.tcharles.nfescrapper.dto.NFERecordDTO;
import com.tcharles.nfescrapper.dto.NFERecordDTOCluster;
import com.tcharles.nfescrapper.dto.StateDTO;
import com.tcharles.nfescrapper.resources.util.URL;
import com.tcharles.nfescrapper.services.NFERecordService;

@RestController
@RequestMapping(value="/records")
public class RecordResources {
	
	@Autowired
	private NFERecordService service;
	
	//Retornar por rest os status atual dos serviços por estado.
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<NFERecordDTO> currentNFERecord(){
		NFErecord record = service.find();
		;
		return ResponseEntity.ok().body(new NFERecordDTO(record));
	}
	
	//Retornar por rest o status atual do serviço filtrando por estado.
	@RequestMapping(value="states/{name}",method=RequestMethod.GET)
	public ResponseEntity<StateDTO> findByStates(@PathVariable String name){
		StateDTO obj = new StateDTO(); 
		
		List<StateDTO> states = service.find().getStates();
		
		for(StateDTO state: states) {
			if(state.getName().equalsIgnoreCase(name)) {
				obj = state;
			}
		}
		
		return ResponseEntity.ok().body(obj);
	}
	
	//Retornar por rest os status dos serviços por estado filtrando por data.
	@RequestMapping(value="/{date}", method=RequestMethod.GET)
 	public ResponseEntity<NFERecordDTO> dateSearch(@PathVariable String date) {
		Date d = URL.convertDate(date, new Date());
		List<NFErecord> obj = service.fullSearch(d);
		if(obj != null) {
			obj.add(new NFErecord());
		}
		
		return ResponseEntity.ok().body(new NFERecordDTO(obj.get(0)));
	}
	
	//Retornar por rest qual estado teve mais indisponibilidade de serviço.
	@RequestMapping(value="/outages", method=RequestMethod.GET)
 	public ResponseEntity<StateDTO> outages() {
		List<NFErecord> records = service.findAll();
		
		NFERecordDTOCluster cluster = new NFERecordDTOCluster(records);
		
		List<StateDTO> states = cluster.getStates();
		Collections.sort(states, Comparator.comparing(StateDTO::getOutages));
		Collections.reverse(states);
		return ResponseEntity.ok().body(states.get(0));
	}
	
}
