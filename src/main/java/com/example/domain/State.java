package com.example.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class State {
	
	private String state;
	private Double maxmp;
	private Double minmp;
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


public String getState() {
	return state;
}


public void setState(String state) {
	this.state = state;
}


public Double getMaxmp() {
	return maxmp;
}


public void setMaxmp(Double maxmp) {
	this.maxmp = maxmp;
}


public Double getMinmp() {
	return minmp;
}


public void setMinmp(Double minmp) {
	this.minmp = minmp;
}


public String getNote() {
	return note;
}


public void setNote(String note) {
	this.note = note;
}

}