package com.example.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.domain.Country;
import com.example.mapper.CountryMapper;

@Service
public class CountryRegisterService {
	
	@Autowired
	CountryMapper countryMapper;
	
	public void register(Country country, BindingResult errors) {
		
		Country confirm = countryMapper.selectByCode(country.getCode());
		if (confirm != null)
			errors.reject("InvalidCountryCode", "중복된 Country Code가 존재합니다.");
		
		if (!errors.hasErrors())
			countryMapper.insert(country);
	}

}
