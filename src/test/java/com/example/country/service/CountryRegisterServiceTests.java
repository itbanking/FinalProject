package com.example.country.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.form.CountryForm;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryRegisterServiceTests {
	
	@Autowired
	CountrySearchService countrySearchService;
	
	@Autowired
	CountryRegisterService countryRegisterService;
	
	@Autowired
	Validator validator;

	@Test
	public void confirmCountrySearchService() {
		System.out.println("CountrySearchService : " + countrySearchService );
	}
	
	@Test
	public void confirmCountryRegisterService() {
		System.out.println("CountryRegisterService : " + countryRegisterService );
	}
	
	@Test
	public void confirmValidator() {
		System.out.println("Validator : " + validator );
	}
	
	@Test
	public void Register() {
		CountryForm countryForm = new CountryForm();
		
		countryForm.setCode("XYZ");
		countryForm.setName("java");
		
		BindingResult errors = new BeanPropertyBindingResult(countryForm, "countryForm");
		
		validator.validate(countryForm, errors);
		
		if ( errors.hasErrors() ) {
			System.out.println("Error(Validate) : " + errors);
			return;
		}
		
		countryRegisterService.register(countryForm, errors);
		if ( errors.hasErrors() ) {
			System.out.println("Error(Register) : " + errors);
			return;
		}
		
		System.out.println("Country : " + countrySearchService.getCountryByCode(countryForm.getCode() ) );
	}

}
