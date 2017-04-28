package com.example.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.domain.Country;
import com.example.mapper.CountryMapper;

@Service
public class CountryModifyService {

	@Autowired
	CountryMapper countryMapper;
	
	public void modify(Country country, BindingResult errors) {
		Country confirm = countryMapper.selectByCode(country.getCode());
		if (confirm == null) 
			errors.reject("InvalidCountryCode", "유효한 Code가 없습니다.");
		
		if(!errors.hasErrors())
			countryMapper.updateByCode(country);
	}
}
