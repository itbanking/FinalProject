package com.example.city.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.form.CityForm;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRegisterServiceTests {
	
	@Autowired
	CitySearchService citySearchService;
	
	@Autowired
	CityRegisterService cityRegisterService;
	
	@Autowired
	Validator validator;

	@Test
	public void confirmCitySearchService() {
		System.out.println("CitySearchService : " + citySearchService );
	}
	
	@Test
	public void confirmCityRegisterService() {
		System.out.println("CityRegisterService : " + cityRegisterService );
	}
	
	@Test
	public void confirmValidator() {
		System.out.println("Validator : " + validator );
	}
	
	@Test
	public void Register() {
		CityForm cityForm = new CityForm();
		BindingResult errors = new BeanPropertyBindingResult(cityForm, "cityForm");
		
		cityForm.setName("xxx");
		cityForm.setCountryCode("KOR");
		
		validator.validate(cityForm, errors);
		if ( errors.hasErrors() ) {
			System.out.println("Errors(Validate) : " + errors);
			return;
		}
		
		cityRegisterService.register(cityForm, errors);
		if ( errors.hasErrors() ) {
			System.out.println("Errors(Register) : " + errors);
			return;
		}
		
		System.out.println("City : " + citySearchService.getCityById( cityForm.getId() ) );
	}

}
