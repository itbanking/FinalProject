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

import com.example.domain.Sal;
import com.example.form.SalForm;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalModifyServiceTests {
	
	@Autowired
	SalSearchService salSearchService;
	
	@Autowired
	SalModifyService salModifyService;
	
	@Autowired
	Validator validator;
	
	@Test
	public void test00_confirm() {
		System.out.println("salSearchService = " + salSearchService);
		System.out.println("salModifyService = " + salModifyService);
		System.out.println("Validator = " + validator);
	}
	
	@Test
	public void test01_modify() {
		Sal sal = salSearchService.getSalBySalno(50);
		SalForm salForm = new SalForm();
		salForm.setSal(sal);
		BindingResult errors = new BeanPropertyBindingResult(salForm, "salForm");
		
		salForm.setComm(new BigDecimal(400));
		salForm.setAidSal(new BigDecimal(30));
		
		validator.validate(salForm, errors);
		if (errors.hasErrors()) {
			System.out.println("errors = " + errors);
			return;
		}
		
		salModifyService.modify(salForm, errors);
		if (errors.hasErrors()) {
			System.out.println("errors = " + errors);
			return;
		}
		
		System.out.println("sal = " + salSearchService.getSalBySalno(salForm.getSalno()));
	}
			
}
