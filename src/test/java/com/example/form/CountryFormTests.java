package com.example.form;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryFormTests {
	
	@Autowired
	Validator validator;
	
	@Test
	public void test00_confirmValidator() {
		System.out.println("validator=" + validator);
	}
	
	@Test
	public void test01_getCode() {
		CountryForm countryForm = new CountryForm();
		countryForm.setCode("XYZZ");
		countryForm.setName("database");
		
		BindingResult errors = new BeanPropertyBindingResult(countryForm, "countryForm");
		
		validator.validate(countryForm, errors);
		
		if (errors.hasErrors()) {
			System.out.println("errors=" + errors);
			return;
		}
		System.out.println("countryForm 는 유효합니다");
	}
	
}










