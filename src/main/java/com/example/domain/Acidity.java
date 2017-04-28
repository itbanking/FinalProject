package com.example.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Acidity {
	
	private String acidity;
	private Double maxpka;
	private Double minpka;
	private String note;
	
	@Override
	public String toString() {
		String str= null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return str;
	}

	public String getAcidity() {
		return acidity;
	}

	public void setAcidity(String acidity) {
		this.acidity = acidity;
	}

	public Double getMaxpka() {
		return maxpka;
	}

	public void setMaxpka(Double maxpka) {
		this.maxpka = maxpka;
	}

	public Double getMinpka() {
		return minpka;
	}

	public void setMinpka(Double minpka) {
		this.minpka = minpka;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

}
