package com.tcharles.nfescrapper.suport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.tcharles.nfescrapper.domain.Record;
import com.tcharles.nfescrapper.dto.ServiceDTO;
import com.tcharles.nfescrapper.dto.StateDTO;

public class Scrapper {
	
	private String url = "http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx";
	private Document doc;
	
	public Scrapper() throws IOException {
		this.doc = Jsoup.connect(this.url).get();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	
	public Record scrape() {
		
		Element table = doc.getElementsByClass("tabelaListagemDados").first();
		Element tbody = table.getElementsByTag("tbody").first();
		List<Element> Records = tbody.getElementsByTag("tr");
		Records.remove(0);
		List<StateDTO> statesObjects = new ArrayList<>();
		
		for (Element record: Records) {
			List<Element> lines = record.getElementsByTag("td");
			if(lines.get(0) != null) {
				 int outages = 0;
				 
				 List<ServiceDTO> services = new ArrayList<>();
				 services.add(converterToService("Autorização",lines.get(1)));
				 services.add(converterToService("Retorno Autorização",lines.get(2)));
				 services.add(converterToService("Inutilização",lines.get(3)));
				 services.add(converterToService("Consulta Protocolo",lines.get(4)));
				 services.add(converterToService("Status Serviço",lines.get(5)));
				 services.add(converterToService("Consulta Cadastr",lines.get(7)));
				 services.add(converterToService("Recepção Evento",lines.get(8)));
				 
				 for(ServiceDTO service: services ) {
					 outages = (service.getStatus() == "off"? outages + 1 : outages);
				 }
				 
				 statesObjects.add(new StateDTO(lines.get(0).text(),outages,services));
			}
		}

		
		return new Record(null, new Date() ,statesObjects);
		
	}
	
	
	private ServiceDTO converterToService(String serviceName, Element td) {
		String name = serviceName;
		String status = null;
		
		if(td.getElementsByTag("img") != null) {
			if(td.getElementsByTag("img").attr("src") != "imagens/bola_verde_P.png") {
				status = "off";
			}
			else {
				status = "on";
			}
		}
		
		return new ServiceDTO(name,status);
	}
	
	
}
