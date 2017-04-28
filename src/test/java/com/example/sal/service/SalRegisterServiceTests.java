package com.example.sal.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.form.SalForm;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalRegisterServiceTests {

	@Autowired
	SalSearchService salSerchService;
	
	@Autowired
	SalRegisterService salRegisterService;
	
	@Autowired
	Validator validator;
	
	@Test
	public void test00_confirm() {
		System.out.println("SearchService = " + salSerchService);
		System.out.println("RegisterService = " + salRegisterService);
		System.out.println("Validator = " + validator);
	}
	
	@Test
	public void test01_register() {
		
		SalForm salForm = new SalForm();
		BindingResult errors = new BeanPropertyBindingResult(salForm, "salForm");
		
		salForm.setBasicSal(new BigDecimal(4000));
		salForm.setOvertimeSal(new BigDecimal(30));
		salForm.setMembersrl(new BigDecimal(2));
		
		validator.validate(salForm, errors);
		if (errors.hasErrors()) {
			System.out.println("errors = " + errors);
			return;
		}
		
		salRegisterService.register(salForm, errors);
		if (errors.hasErrors()) {
			System.out.println("errors = " + errors);
			return;
		}
		
		System.out.println("sal = " + salSerchService.getSalBySalno(salForm.getSalno()));
			
	}
}
