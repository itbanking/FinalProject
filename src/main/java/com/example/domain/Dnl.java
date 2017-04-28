package com.example.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Dnl {

	private int dnlCode;
	private String dnlType;
	private Dnltime dnltimes;

	public Dnltime getDnltimes() {
		return dnltimes;
	}

	public void setDnltimes(Dnltime dnltimes) {
		this.dnltimes = dnltimes;
	}

	public Dnl() {
		// TODO Auto-generated constructor stub
	}
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

	public int getDnlCode() {
		return dnlCode;
	}

	public void setDnlCode(int dnlCode) {
		this.dnlCode = dnlCode;
	}

	public String getDnlType() {
		return dnlType;
	}

	public void setDnlType(String dnlType) {
		this.dnlType = dnlType;
	}


}
