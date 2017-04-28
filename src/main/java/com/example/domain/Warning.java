package com.example.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Warning {
	
	private String hazardStatements;
	private String description;

	
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


	public String getHazardStatements() {
		return hazardStatements;
	}


	public void setHazardStatements(String hazardStatements) {
		this.hazardStatements = hazardStatements;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}


