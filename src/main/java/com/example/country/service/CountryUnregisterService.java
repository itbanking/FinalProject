package com.example.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.CountryMapper;

@Service
public class CountryUnregisterService {
	
	@Autowired
	CountryMapper countryMapper;
	
	public void unregister(String code) {
		
		countryMapper.deleteByCode(code);
		
	}
}
